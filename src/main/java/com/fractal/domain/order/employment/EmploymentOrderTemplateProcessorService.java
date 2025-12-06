package com.fractal.domain.order.employment;

import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.utilities.converter.NumberToWordConverter;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
class EmploymentOrderTemplateProcessorService {

    private final EmployeeUseCaseService employeeUseCaseService;
    private final VacationAccrualService vacationAccrualService;
    private final EmployeeEmploymentService employeeEmploymentService;


    public Map<String,String> process(EmploymentOrder order){
        return switch (order.getOrderType().getCode()) {
            case "EMPLOYHIRE","EMPLOYHIRESURCH" -> getPermanentValues(order);
            case "NONLISTHIRE","OFFLISTHIRE" -> getContractServiceValues(order);
            case "TERMCONTRACT" -> getTerminationValues(order);
            case "PERMTRANSFER" -> getInternalTransferValues(order);
            case "EMPTRANSFER" -> getInterOrganizationTransferValues(order);
            case "TEMPTRANSFER" -> getTemporaryTransferValues(order);
            case "EMPROTATE" -> getRotationValues(order);
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

        values.put("startDate", employment.startDate().toString());
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }
    private Map<String,String> getContractServiceValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getEmployment(getEmployment(order)).get();

        values.put("departmentName", employment.department().name());
        values.put("startDate", employment.startDate().toString());
        values.put("endDate", employment.endDate().toString());
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }
    private Map<String,String> getTerminationValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getEmployment(getEmployment(order)).get();
        var calendarDays = vacationAccrualService.getAllEmployeeRemainingDays(getEmployment(order).getEmployee().getId());

        values.put("fullBankName", employment.organization().name());
        values.put("departmentName", employment.department().name());
        values.put("startDate", employment.endDate().toString());
        values.put("unusedCalendarDays", String.valueOf(calendarDays));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }
    private Map<String,String> getInternalTransferValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getEmployment(getEmployment(order)).get();
        var previousEmployment = (InternalEmploymentResponse) employeeEmploymentService.toDTO(employeeEmploymentService.getActiveBefore(getEmployment(order).getEmployee().getId(),employment.startDate()));

        values.put("employeeOldPosition", previousEmployment.position().name());
        values.put("startDate", employment.endDate().toString());
        values.putAll(getSalaryValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }
    private Map<String,String> getInterOrganizationTransferValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getEmployment(getEmployment(order)).get();
        var previousEmployment = (InternalEmploymentResponse) employeeEmploymentService.toDTO(employeeEmploymentService.getActiveBefore(getEmployment(order).getEmployee().getId(),employment.startDate()));

        values.put("employeeOldPosition", previousEmployment.position().name());
        values.put("oldOrganizationName", previousEmployment.organization().name());
        values.put("newOrganizationName", employment.organization().name());
        values.put("startDate", employment.endDate().toString());
        values.put("endDate", employment.endDate().toString());
        values.putAll(getSalaryValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }



    private Map<String,String> getTemporaryTransferValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getEmployment(getEmployment(order)).get();
        var previousEmployment = (InternalEmploymentResponse) employeeEmploymentService.toDTO(employeeEmploymentService.getActiveBefore(getEmployment(order).getEmployee().getId(),employment.startDate()));

        values.put("employeeOldPosition", previousEmployment.position().name());
        values.put("oldOrganizationName", previousEmployment.organization().name());
        values.put("newOrganizationName", employment.organization().name());
        values.put("startDate", employment.endDate().toString());
        values.put("endDate", employment.endDate().toString());
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }
    private Map<String,String> getRotationValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeUseCaseService.getEmployment(getEmployment(order)).get();
        var previousEmployment = (InternalEmploymentResponse) employeeEmploymentService.toDTO(employeeEmploymentService.getActiveBefore(getEmployment(order).getEmployee().getId(),employment.startDate()));

        values.put("employeeOldPosition", previousEmployment.position().name());
        values.put("oldDepartment", previousEmployment.department().name());
        values.put("newDepartment", employment.department().name());
        values.put("startDate", employment.endDate().toString());
        values.put("endDate", employment.endDate().toString());
        values.put("days", String.valueOf(Duration.between(employment.startDate(),employment.endDate().plusDays(1))));
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }

    private Map<String,String> getSalaryValues(InternalEmploymentResponse employment) {
        Map<String,String> values = new HashMap<>();
        var compensationComponent  = employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("BASICSALARY")).findFirst().get();
        values.put("newSalary", compensationComponent.grossAmount().toString());
        values.put("newSalaryInLetters", NumberToWordConverter.convert(compensationComponent.grossAmount().longValue()));
        return values;
    }
    private Map<String,String> getSurchargeValues(InternalEmploymentResponse employment){
        Map<String,String> values = new HashMap<>();
        var compensationComponent  = employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("ADDITIONALSALARY")).findFirst().get();
        values.put("surcharge", compensationComponent.grossAmount().toString());
        values.put("surchargeInLetters", NumberToWordConverter.convert(compensationComponent.grossAmount().longValue()));
        return values;
    }

    private EmployeeEmployment getEmployment(EmploymentOrder order){
        return order.getRecords().getFirst().getEmployment();
    }

}
