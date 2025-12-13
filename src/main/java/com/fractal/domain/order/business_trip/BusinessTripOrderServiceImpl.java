package com.fractal.domain.order.business_trip;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.location.mapper.BusinessTripLocationMapperService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;
import com.fractal.domain.order.business_trip.mapper.BusinessTripOrderMapperService;
import com.fractal.domain.order.business_trip.record.BusinessTripOrderRecord;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecordService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessTripOrderServiceImpl implements BusinessTripOrderService {

    private final BusinessTripService businessTripService;
    private final BusinessTripOrderRepository orderRepository;
    private final BusinessTripOrderMapperService orderMapperService;
    private final OrderStateService stateService;
    private final StatusService statusService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final OrderUseCaseService orderUseCaseService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final FileService fileService;
    private final AuthenticatedService authenticatedService;
    private final BusinessTripLocationMapperService businessTripLocationMapperService;


    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;


    @Override
    @Transactional
    public BusinessTripOrder create(BusinessTripOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
        order.setStatus(statusService.getByCode("CREATED"));
        return save(order);
    }

    @Override
    public List<BusinessTripOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public BusinessTripOrder getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public BusinessTripOrder getByBusinessTripId(Long businessTripId) {
        return orderRepository.findByBusinessTripId(businessTripId).orElseThrow(()-> new ResourceNotFoundException("BusinessTrip in BusinessTripOrderRecord with id: " + businessTripId + " not found"));
    }

    @Override
    @Transactional
    public BusinessTripOrder update(Long id, BusinessTripOrderRequest dto) {
        return save(orderMapperService.toEntity(getById(id), dto));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.delete(getById(id));
    }



    @Override
    public BusinessTripOrderResponse toDTO(BusinessTripOrder order) {
        return orderMapperService.toDTO(order);
    }

    @Override
    @Transactional
    public BusinessTripOrder save(BusinessTripOrder order) {
        try {
            order = orderRepository.save(order);
            stateService.create(order);
            return order;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public BusinessTripOrder review(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            order.setReviewedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("REVIEWED"));
            return save(order);
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public BusinessTripOrder approve(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            order.getRecords().forEach(record -> {
                businessTripService.activate(record.getBusinessTrip().getId());
            });
            order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            order.setStatus(order.getStatus());
            return save(order);
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public Path print(Long id)   {
        var order = getById(id);
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath =  Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();
        Map<String, String> values = new HashMap<>();
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(order.getOrderType().getDocumentTemplateManager().getFilePath()));
             values.putAll(orderUseCaseService.getHeader(order));
             values.put("sourceDocument", order.getSourceDocument());
             values.putAll(orderUseCaseService.getFooter());
             document = writeTable(document,order);
             wordTemplateProcessorService.processDocument(document,values);
            try (FileOutputStream out = new FileOutputStream(wordFilePath.toFile())) {
                document.write(out);
                wordToPdfConverterService.convert(wordFilePath,pdfFilePath);
                fileService.delete(wordFilePath.toString());
            }
        }
        catch (Exception e){}
       return pdfFilePath;
    }

    private String getLocation(BusinessTrip businessTrip){
        StringBuilder fullAddress = new StringBuilder();
        var businessTripLocationResponse = businessTripService.toDTO(businessTrip).locations().getFirst();
        var address = businessTripLocationResponse.addresses().getFirst();
        if (businessTripLocationResponse.locationType().code().equals("INTERNAL")) {
            if(address.district().name() != null)
                fullAddress.append(address.district().name());
            else fullAddress.append(address.city().name());
        }
        else if (businessTripLocationResponse.locationType().code().equals("EXTERNAL"))
            fullAddress.append(address.country().name());

        return fullAddress.toString();
    }


    private XWPFDocument writeTable(XWPFDocument document,BusinessTripOrder order) throws Exception {
           XWPFTable targetTable = document.getTables().get(1);

            var headerRow = targetTable.getRow(0);
            int i = 0;
            var number = 1;
            for(BusinessTripOrderRecord record: order.getRecords()) {
                XWPFTableRow row;
                var employeeName = employeeUseCaseService.getFullName(record.getBusinessTrip().getEmployee());
                var employment = employeeUseCaseService.getCurrentEmployment(record.getBusinessTrip().getEmployee());
                row = i + 1 < targetTable.getNumberOfRows() ? targetTable.getRow(i + 1) : targetTable.createRow();

                List<String> rowData = new ArrayList<>();
                rowData.add(String.valueOf(number));
                rowData.add(employeeName);
                employment.ifPresent(employmentResponse -> {
                    rowData.add(employmentResponse.position().name());
                });
                rowData.add(record.getBusinessTrip().getStartDate().toString());
                rowData.add(record.getBusinessTrip().getEndDate().toString());
                rowData.add(record.getBusinessTrip().getDays().toString());
                rowData.add(record.getBusinessTrip().getDescription());
                rowData.add(getLocation(record.getBusinessTrip()));
                number++;

                for (int j = 0; j < rowData.size(); j++) {
                    XWPFTableCell cell;
                    if (j < row.getTableCells().size()) {
                        cell = row.getCell(j);
                    } else {
                        cell = row.addNewTableCell();
                    }
                    cell.setText(rowData.get(j));

                    if (j < headerRow.getTableCells().size()) {
                        XWPFTableCell headerCell = headerRow.getCell(j);
                        cell.getCTTc().setTcPr(headerCell.getCTTc().getTcPr());

                        // Remove any existing paragraph
                        cell.removeParagraph(0);

                        for (XWPFParagraph headerParagraph : headerCell.getParagraphs()) {
                            XWPFParagraph p = cell.addParagraph();
                            p.getCTP().setPPr(headerParagraph.getCTP().getPPr());

                            XWPFRun run = p.createRun();
                            if (!headerParagraph.getRuns().isEmpty()) {
                                XWPFRun headerRun = headerParagraph.getRuns().get(0);
                                run.getCTR().setRPr(headerRun.getCTR().getRPr());
                                run.setBold(false);
                                run.setFontSize(8);
                            }
                            run.setText(rowData.get(j));
                        }
                    } else {
                        cell.setText(rowData.get(j));
                    }
                }
           };
         return document;
    }



}
