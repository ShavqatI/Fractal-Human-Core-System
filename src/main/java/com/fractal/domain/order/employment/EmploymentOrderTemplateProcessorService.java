package com.fractal.domain.order.employment;

import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.utilities.converter.NumberToWordConverter;
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
    private final OrderUseCaseService orderUseCaseService;

    public Map<String,String> process(EmploymentOrder order){
        return switch (order.getOrderType().getCode()) {
            case "EMPLOYHIRE","EMPLOYHIRESURCH" -> getPermanentValues(order);
            case "NONLISTHIRE","OFFLISTHIRE" -> getContractServiceValues(order);
            /*case "PREGNANCY" -> getPregnancyValues(order);
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
        var employment = employeeUseCaseService.getEmployment(getEmployment(order)).get();

        var compensationComponent  = employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("BASICSALARY")).findFirst().get();

        values.put("startDate", employment.startDate().toString());
        values.put("newSalary", compensationComponent.grossAmount().toString());
        values.put("newSalaryInLetters", NumberToWordConverter.convert(compensationComponent.grossAmount().longValue()));
        values.putAll(getSurchargeValues(order));
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }
    private Map<String,String> getContractServiceValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getEmployment(getEmployment(order)).get();

        var compensationComponent  = employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("BASICSALARY")).findFirst().get();

        values.put("departmentName", employment.department().name());
        values.put("startDate", employment.startDate().toString());
        values.put("endDate", employment.endDate().toString());
        values.put("newSalary", compensationComponent.grossAmount().toString());
        values.put("newSalaryInLetters", NumberToWordConverter.convert(compensationComponent.grossAmount().longValue()));
        values.putAll(getSurchargeValues(order));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }

    private Map<String,String> getSurchargeValues(EmploymentOrder order){
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(getEmployment(order).getEmployee()).get();
        employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("ADDITIONALSALARY")).findFirst().ifPresent(cc->{
            values.put("surcharge",cc.grossAmount().toString());
            values.put("surchargeInLetters",NumberToWordConverter.convert(cc.grossAmount().longValue()));
        });
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

    private EmployeeEmployment getEmployment(EmploymentOrder order){
        return order.getRecords().getFirst().getEmployment();
    }

}
