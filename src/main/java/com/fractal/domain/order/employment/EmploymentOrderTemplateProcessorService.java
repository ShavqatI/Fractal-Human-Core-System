package com.fractal.domain.order.employment;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.utilities.converter.NumberToWordConverter;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
class EmploymentOrderTemplateProcessorService {

    private final VacationAccrualService vacationAccrualService;
    private final EmployeeEmploymentService employeeEmploymentService;
    private final OrganizationService organizationService;


    public Map<String,String> process(EmploymentOrder order){
        return switch (order.getOrderType().getCode()) {
            case "EMPLOYHIRE","EMPLOYHIRESURCH" -> getPermanentValues(order);
            case "NONLISTHIRE","OFFLISTHIRE" -> getContractServiceValues(order);
            case "TERMCONTRACT" -> getTerminationValues(order);
            case "PERMTRANSFER" -> getInternalTransferValues(order);
            case "EMPTRANSFER" -> getInterOrganizationTransferValues(order);
            case "TEMPTRANSFER" -> getTemporaryTransferValues(order);
            case "EMPROTATE" -> getRotationValues(order);
            default -> new HashMap<>();
        };
    }

    private Map<String,String> getPermanentValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(order)).get();

        values.put("startDate", employment.startDate().toString());
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));
        return values;
    }
    private Map<String,String> getContractServiceValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(order)).get();

        values.put("departmentName", employment.department().name());
        values.put("startDate", employment.startDate().toString());
        values.put("endDate", employment.endDate() != null ?  employment.endDate().toString() : null);
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));

      return values;
    }
    private Map<String,String> getTerminationValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(order)).get();
        var calendarDays = vacationAccrualService.getAllEmployeeRemainingDaysForCompensation(getEmployment(order).getEmployee().getId());

        values.put("fullBankName", employment.organization().name());
        values.put("departmentName", employment.department().name());
        values.put("startDate", employment.endDate().toString());
        values.put("unusedCalendarDays", String.valueOf(calendarDays));

      return values;
    }
    private Map<String,String> getInternalTransferValues(EmploymentOrder order) {
        Map<String, String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(order)).get();
        var previousEmployment = (InternalEmploymentResponse) employeeEmploymentService.toDTO(employeeEmploymentService.getActiveBefore(getEmployment(order).getEmployee().getId(), employment.startDate()));
        values.put("employeeOldPosition", previousEmployment.position().name());
        values.put("startDate", employment.endDate().toString());
        values.putAll(getSalaryValues(employment));
      return values;
    }
    private Map<String,String> getInterOrganizationTransferValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(order)).get();
        var previousEmployment = (InternalEmploymentResponse) employeeEmploymentService.toDTO(employeeEmploymentService.getActiveBefore(getEmployment(order).getEmployee().getId(),employment.startDate()));

        values.put("employeeOldPosition", previousEmployment.position().name());
        values.put("oldOrganizationName", previousEmployment.organization().name());
        values.put("oldOrganizationAddress", getOrganizationAddress(previousEmployment));
        values.put("organizationName", employment.organization().name());
        values.put("organizationAddress", getOrganizationAddress(employment));
        values.put("startDate", employment.startDate().toString());
        values.putAll(getSalaryValues(employment));
      return values;
    }



    private Map<String,String> getTemporaryTransferValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(order)).get();
        var previousEmployment = (InternalEmploymentResponse) employeeEmploymentService.toDTO(employeeEmploymentService.getActiveBefore(getEmployment(order).getEmployee().getId(),employment.startDate()));

        values.put("employeeOldPosition", previousEmployment.position().name());
        values.put("oldOrganizationName", previousEmployment.organization().name());
        values.put("oldOrganizationAddress", getOrganizationAddress(previousEmployment));
        values.put("organizationName", employment.organization().name());
        values.put("organizationAddress", getOrganizationAddress(employment));
        values.put("startDate", employment.endDate().toString());
        values.put("endDate", employment.endDate() != null ?  employment.endDate().toString() : null);
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));
      return values;
    }
    private Map<String,String> getRotationValues(EmploymentOrder order) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(order)).get();
        var previousEmployment = (InternalEmploymentResponse) employeeEmploymentService.toDTO(employeeEmploymentService.getActiveBefore(getEmployment(order).getEmployee().getId(),employment.startDate()));

        values.put("employeeOldPosition", previousEmployment.position().name());
        values.put("oldOrganizationName", previousEmployment.organization().name());
        values.put("oldOrganizationAddress", getOrganizationAddress(previousEmployment));
        values.put("organizationName", employment.organization().name());
        values.put("organizationAddress", getOrganizationAddress(employment));
        values.put("startDate", employment.endDate().toString());
        values.put("endDate", employment.endDate() != null ?  employment.endDate().toString() : null);
        values.put("days", String.valueOf((int) ChronoUnit.DAYS.between(employment.startDate(), employment.endDate().plusDays(1))));
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));

      return values;
    }

    private Map<String,String> getSalaryValues(InternalEmploymentResponse employment) {
        Map<String,String> values = new HashMap<>();
        var compensationComponent  = employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("BASICSALARY")).findFirst();
        if(compensationComponent.isPresent()){
            var amount = compensationComponent.get().grossAmount();
            values.put("newSalary", amount.toString());
            values.put("newSalaryInLetters", NumberToWordConverter.convert(amount.longValue()));
        }
       return values;
    }
    private Map<String,String> getSurchargeValues(InternalEmploymentResponse employment){
        Map<String,String> values = new HashMap<>();
        var compensationComponent  = employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("ADDITIONALSALARY")).findFirst();
        if(compensationComponent.isPresent()){
            var amount = compensationComponent.get().grossAmount();
            values.put("surcharge", amount.toString());
            values.put("surchargeInLetters", NumberToWordConverter.convert(amount.longValue()));
        }
       return values;
    }

    private EmployeeEmployment getEmployment(EmploymentOrder order){
        return order.getRecords().getFirst().getEmployment();
    }

    private String getOrganizationAddress(InternalEmploymentResponse employment){
        var organization = organizationService.toDTO(organizationService.getById(employment.organization().id()));
        if(organization.addresses().size() > 0){
            var address = organization.addresses().getLast();
                return address.city().name() == null ?
                        address.district().name() == null ? address.district().name() : ""
                        : address.city().name();
        }
      else return "";
    }

}
