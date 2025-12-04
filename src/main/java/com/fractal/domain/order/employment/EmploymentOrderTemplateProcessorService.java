package com.fractal.domain.order.employment;

import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
class EmploymentOrderTemplateProcessorService {

    private final EmployeeUseCaseService employeeUseCaseService;
    private final VacationAccrualPeriodRecordService vacationAccrualPeriodRecordService;
    private final OrderUseCaseService orderUseCaseService;

    private VacationAccrualPeriod getPeriod(Long recordId){
        return vacationAccrualPeriodRecordService.getById(recordId).getVacationAccrualPeriod();
    }

    public Map<String,String> process(EmploymentOrder order){
        return switch (order.getOrderType().getCode()) {
            case "EMPLOYHIRE" -> getPermanentValues(order);
            /*case "SICKVACATION" -> getSickValues(order);
            case "PREGNANCY" -> getPregnancyValues(order);
            case "PATERNITY" -> getPaternityValues(order);
            case "CHILDCARE" -> getChildCareValues(order);
            case "FUNERAL" -> getFuneralValues(order);
            case "EDUCATION" -> getEducationValues(order);
            case "UNPAID" -> getUnpaidValues(order);
            case "CASUAL" -> getCasualValues(order);
            case "RECALL" -> getRecallValues(order);*/
            default -> new HashMap<>();
        };
    }

    private Map<String,String> getPermanentValues(EmploymentOrder order) {
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
    private Map<String,String> getUnpaidValues(VacationOrder order) {
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
    private Map<String,String> getSickValues(VacationOrder order) {
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

    private Map<String,String> getCasualValues(VacationOrder order) {
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


    private Map<String,String> getRecallValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();

        var request = order.getVacation().getVacationRequest();
        values.put("fullBankName", employment.organization().name());
        values.put("startDate", request.getStartDate().toString());
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }
    private Map<String,String> getPregnancyValues(VacationOrder order) {
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
    private Map<String,String> getPaternityValues(VacationOrder order) {
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
    private Map<String,String> getChildCareValues(VacationOrder order) {
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
    private Map<String,String> getFuneralValues(VacationOrder order) {
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
    private Map<String,String> getEducationValues(VacationOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();
        var request = order.getVacation().getVacationRequest();
        var universityName = request.getEducations().getFirst().getInstitutionName();
        System.out.println(universityName);
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

}
