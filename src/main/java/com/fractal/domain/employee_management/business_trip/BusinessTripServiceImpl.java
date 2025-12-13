package com.fractal.domain.employee_management.business_trip;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManagerService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.employee_management.business_trip.mapper.BusinessTripMapperService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.order.business_trip.BusinessTripOrder;
import com.fractal.domain.order.business_trip.BusinessTripOrderService;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class BusinessTripServiceImpl implements BusinessTripService {

    private final BusinessTripRepository businessTripRepository;
    private final BusinessTripMapperService mapperService;
    private final StatusService statusService;
    private final AuthenticatedService authenticatedService;
    private final FileService fileService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final DocumentTemplateManagerService documentTemplateManagerService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final BusinessTripOrderService businessTripOrderService;
    private final EmployeeEmploymentUseCaseService employeeEmploymentUseCaseService;

    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;



    @Override
    public BusinessTrip create(BusinessTripRequest dto) {
        var businessTrip = mapperService.toEntity(dto);
        return save(businessTrip);

    }

    @Override
    public List<BusinessTrip> getAll() {
        return businessTripRepository.findAll();
    }

    @Override
    public BusinessTrip getById(Long id) {
        return findById(id);
    }

    @Override
    public List<BusinessTrip> getAllByEmployeeId(Long employeeId) {
        return businessTripRepository.findAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public BusinessTrip update(Long id, BusinessTripRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id), dto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
    @Override
    public void deleteById(Long id) {
        businessTripRepository.delete(findById(id));
    }

    @Override
    public void close(Long id) {
        var businessTrip = findById(id);
        businessTrip.setStatus(statusService.getByCode("CLOSE"));
        save(businessTrip);
    }

    @Override
    public Path passport(Long id) {
        var businessTrip = getById(id);
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath =  Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();

        Map<String, String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(businessTrip.getEmployee()).get();
        var oder = getOrder(businessTrip);
        var identificationDocument = employeeUseCaseService.getIdentificationDocument(businessTrip.getEmployee());

        values.put("oderDate", businessTrip.getCreatedDate().toString());
        values.put("employeeName", employeeUseCaseService.getFullName(businessTrip.getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("calendarDays", businessTrip.getDays().toString());
        values.put("startDate", businessTrip.getStartDate().toString());
        values.put("endDate", businessTrip.getEndDate().toString());
        values.put("location", getLocation(businessTrip));
        values.put("description", businessTrip.getDescription());
        values.put("oderNumber", oder.getNumber().toString());
        values.put("oderDate", oder.getDate().toString());

        identificationDocument.ifPresent(identificationDocumentResponse -> {
            values.put("idSeries", identificationDocumentResponse.series());
            values.put("idNumber", identificationDocumentResponse.number().toString());
            values.put("idIssueDate", identificationDocumentResponse.issueDate().toString());
            values.put("idIssuer", identificationDocumentResponse.issueOrganization());
        });
        values.put("hrHead",employeeUseCaseService.getLastNameWithInitials(employeeEmploymentUseCaseService.getHrHeadEmployee()));


        try {
            var template = documentTemplateManagerService.getByCode("BUSSINESSTRIPCERTIF");
            wordTemplateProcessorService.process(Path.of(template.getFilePath()), wordFilePath, values);
            wordToPdfConverterService.convert(wordFilePath,pdfFilePath);
            fileService.delete(wordFilePath.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pdfFilePath;
    }

    public BusinessTripResponse toDTO(BusinessTrip businessTrip) {
        return mapperService.toDTO(businessTrip);
    }

    @Override
    public BusinessTrip save(BusinessTrip businessTrip) {
        try {
            return businessTripRepository.save(businessTrip);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private BusinessTrip findById(Long id) {
        return businessTripRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("BusinessTrip with id: " + id + " not found"));
    }

    @Override
    public BusinessTrip review(Long id) {
        var businessTrip = getById(id);
        if (businessTrip.getStatus().getCode().equals("CREATED")) {
            businessTrip.setApprovedDate(LocalDateTime.now());
            businessTrip.setApprovedUser(authenticatedService.getUser());
            businessTrip.setStatus(statusService.getByCode("REVIEWED"));
            return save(businessTrip);
        } else {
            throw new ResourceStateException("The status is not valid is: " + businessTrip.getStatus().getName());
        }
    }

    @Override
    public BusinessTrip approve(Long id) {
        var businessTrip = getById(id);
        if (businessTrip.getStatus().getCode().equals("REVIEWED")) {
            businessTrip.setApprovedDate(LocalDateTime.now());
            businessTrip.setApprovedUser(authenticatedService.getUser());
            businessTrip.setStatus(statusService.getByCode("APPROVED"));
            return save(businessTrip);
        } else {
            throw new ResourceStateException("The status is not valid is: " + businessTrip.getStatus().getName());
        }
    }

    private String getLocation(BusinessTrip businessTrip){
        StringBuilder fullAddress = new StringBuilder();
        var businessTripLocationResponse = toDTO(businessTrip).locations().getFirst();
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

    private BusinessTripOrder getOrder(BusinessTrip businessTrip){
       return businessTripOrderService.getByBusinessTripId(businessTrip.getId());
    }
}
