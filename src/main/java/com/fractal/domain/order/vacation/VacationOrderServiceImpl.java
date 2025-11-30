package com.fractal.domain.order.vacation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;
import com.fractal.domain.order.vacation.mapper.VacationOrderMapperService;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualRequest;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriodService;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecordService;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import com.fractal.domain.vacation_management.vacation.VacationService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class VacationOrderServiceImpl implements VacationOrderService {

    private final VacationOrderRepository orderRepository;
    private final VacationOrderMapperService orderMapperService;
    private final StatusService statusService;
    private final OrderStateService stateService;
    private final VacationService vacationService;
    private final VacationRequestService vacationRequestService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final OrderUseCaseService orderUseCaseService;
    private final FileService fileService;
    private final VacationAccrualPeriodRecordService vacationAccrualPeriodRecordService;
    private final AuthenticatedService authenticatedService;
    private final VacationAccrualService vacationAccrualService;
    private final VacationTypeService vacationTypeService;




    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;

    @Override
    @Transactional
    public VacationOrder create(VacationOrderRequest dto) {
        var order = orderRepository.save(orderMapperService.toEntity(dto));
        order.setStatus(statusService.getByCode("CREATED"));
        order.getVacation().setStatus(order.getStatus());
        stateService.create(order);
        return order;
    }

    @Override
    public List<VacationOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public VacationOrder getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public VacationOrder update(Long id, VacationOrderRequest dto) {
        var order = getById(id);
        order = orderMapperService.toEntity(order,dto);
        order.getVacation().setStatus(order.getStatus());
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var oder = getById(id);
        vacationService.deleteById(oder.getVacation().getId());
        orderRepository.delete(getById(id));
    }

    @Override
    public VacationOrderResponse toDTO(VacationOrder order) {
        return orderMapperService.toDTO(order);
    }

    @Override
    public VacationOrder review(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            order.setReviewedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("REVIEWED"));
            order.getVacation().setStatus(order.getStatus());
            stateService.create(order);
            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public VacationOrder approve(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            order.getVacation().setStatus(order.getStatus());
            vacationService.close(order.getVacation().getId());
            vacationRequestService.close(order.getVacation().getVacationRequest().getId());
            stateService.create(order);
            order.getVacation().getAllocations().forEach(allocation -> vacationAccrualPeriodRecordService.decrease(allocation.getVacationAccrualPeriodRecord().getId(), allocation.getDays()));
            addAccrualOnRecall(order);
            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }

    }
    @Override
    public Path print(Long id)  {
        var order = getById(id);
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath =  Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();

        Map<String, String> values = new HashMap<>();

        values.putAll(orderUseCaseService.getHeader(order));
        values.putAll(getCommonValues(order));
        values.putAll(typeDecision(order));
        values.putAll(orderUseCaseService.getFooter());

        try {
            wordTemplateProcessorService.process(Path.of(order.getOrderType().getDocumentTemplateManager().getFilePath()), wordFilePath, values);
            wordToPdfConverterService.convert(wordFilePath,pdfFilePath);
            fileService.delete(wordFilePath.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pdfFilePath;
    }

    private VacationAccrualPeriod getPeriod(Long recordId){
        return vacationAccrualPeriodRecordService.getById(recordId).getVacationAccrualPeriod();
    }

    private Map getCommonValues(VacationOrder order){
        Map<String, String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();

        values.put("employeeName", employeeUseCaseService.getFullName(order.getVacation().getEmployee()));
        values.put("employeePosition", employment.position().name());

        return values;
    }
    private Map getAnnualValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();

        var request = order.getVacation().getVacationRequest();
        var period = getPeriod(order.getVacation().getAllocations().stream().findFirst().get().getVacationAccrualPeriodRecord().getId());

        values.put("fullBankName", employment.organization().name());
        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("startDateYear", period.getStartDate().toString());
        values.put("endDateYear", period.getEndDate().toString());
        values.put("returnDay", request.getWorkingDate().toString());
        values.put("successorEmployeeName", employeeUseCaseService.getFullName(request.getSuccessorEmployee()));
        values.put("percent", order.getVacation().getSuccessorCompensationPercentage().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }
    private Map getUnpaidValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var request = order.getVacation().getVacationRequest();

        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("successorEmployeeName", employeeUseCaseService.getFullName(request.getSuccessorEmployee()));
        values.put("percent", order.getVacation().getSuccessorCompensationPercentage().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }
    private Map getSickValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();
        var successorEmployment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getVacationRequest().getSuccessorEmployee()).get();
        var request = order.getVacation().getVacationRequest();

        values.put("fullBankName", employment.organization().name());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("successorEmployeeName", employeeUseCaseService.getFullName(request.getSuccessorEmployee()));
        values.put("successorEmployeePosition", successorEmployment.position().name());
        values.put("percent", order.getVacation().getSuccessorCompensationPercentage().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
        values.put("ceo", orderUseCaseService.getCEO());
        return values;
   }

    private Map getCasualValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();

        var request = order.getVacation().getVacationRequest();

        values.put("fullBankName", employment.organization().name());
        values.put("department", employment.department().name());
        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("returnDay", request.getWorkingDate().toString());
        values.put("successorEmployeeName", employeeUseCaseService.getFullName(request.getSuccessorEmployee()));
        values.put("percent", order.getVacation().getSuccessorCompensationPercentage().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }


    private Map getRecallValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();

        var request = order.getVacation().getVacationRequest();
        values.put("fullBankName", employment.organization().name());
        values.put("startDate", request.getStartDate().toString());
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }
    private Map getPregnancyValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();
        var request = order.getVacation().getVacationRequest();

        values.put("fullBankName", employment.organization().name());
        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("returnDay", request.getWorkingDate().toString());
        values.put("sourceDocument", order.getSourceDocument());
       return values;

    }
    private Map getPaternityValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();
        var request = order.getVacation().getVacationRequest();

        values.put("fullBankName", employment.organization().name());
        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("returnDay", request.getWorkingDate().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
       return values;

    }
    private Map getChildCareValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();
        var request = order.getVacation().getVacationRequest();

        values.put("fullBankName", employment.organization().name());
        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("returnDay", request.getWorkingDate().toString());
        values.put("successorEmployeeName", employeeUseCaseService.getFullName(request.getSuccessorEmployee()));
        values.put("percent", order.getVacation().getSuccessorCompensationPercentage().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
       return values;

    }
    private Map getFuneralValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();
        var request = order.getVacation().getVacationRequest();

        values.put("fullBankName", employment.organization().name());
        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
       return values;
    }
    private Map getEducationValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();
        var request = order.getVacation().getVacationRequest();
        var universityName = request.getEducations().getFirst().getInstitutionName();

        values.put("fullBankName", employment.organization().name());
        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("returnDay", request.getWorkingDate().toString());
        values.put("universityName", universityName);

        values.put("successorEmployeeName", employeeUseCaseService.getFullName(request.getSuccessorEmployee()));
        values.put("percent", order.getVacation().getSuccessorCompensationPercentage().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
       return values;
    }
    private Map<String,String> typeDecision(VacationOrder order){
        switch (order.getVacation().getVacationRequest().getVacationType().getCode()) {
            case "ANNUAL":
                return getAnnualValues(order);
            case "SICKVACATION":
                return getSickValues(order);
            case "PREGNANCY":
                return getPregnancyValues(order);
            case "PATERNITY":
                return getPaternityValues(order);
            case "CHILDCARE":
                return getChildCareValues(order);
            case "FUNERAL":
                return getFuneralValues(order);
            case "EDUCATION":
                return getEducationValues(order);
            case "UNPAID" :
                return getUnpaidValues(order);
            case "CASUAL" :
                return getCasualValues(order);
            case "RECALL" :
                return getRecallValues(order);
            default: return new HashMap<>();
        }
    }



    private void addAccrualOnRecall(VacationOrder order){
        var request = vacationRequestService.getById(order.getVacation().getVacationRequest().getId());
        if (request.getVacationType().getCode().equals("RECALL")){
            var accrual = vacationAccrualService.getAllByEmployeeId(order.getVacation().getEmployee().getId()).getFirst();
            var period = accrual.getPeriods().stream()
                    .filter(p-> statusService.getById(p.getStatus().getId()).getCode().equals("ACTIVE"))
                    .sorted(Comparator.comparing(AbstractEntity::getId).reversed()).findFirst();
            vacationAccrualPeriodRecordService.create(
                    period.get().getId(),
                    new VacationAccrualPeriodRecordRequest(
                            vacationTypeService.getByCode("UNPAID").getId(),
                            order.getDate(),
                            request.getDays(),
                            0,
                            request.getDays(),
                            statusService.getByCode("ACTIVE").getId()
                    )
            );
        }
    }
}
