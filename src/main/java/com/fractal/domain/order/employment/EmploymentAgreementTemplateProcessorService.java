package com.fractal.domain.order.employment;

import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.utility.converter.NumberToWordConverter;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
class EmploymentAgreementTemplateProcessorService {

    private final EmployeeEmploymentService employeeEmploymentService;
    private final OrganizationService organizationService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final EmployeeEmploymentUseCaseService employeeEmploymentUseCaseService;



    public Map<String,String> process(EmploymentOrder order){
        var employeeEmployment = getEmployment(order);
        return switch (employeeEmployment.getEmployment().getEmploymentType().getCode()) {
            case "PERMANENT" -> getPermanentValues(order);
            case "CONTRACT" -> getContractServiceValues(order);
            default -> new HashMap<>();
        };
    }

    private Map<String,String> getPermanentValues(EmploymentOrder order) {
        var employeeEmployment = getEmployment(order);
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(order)).get();
        var identificationDocument = employeeUseCaseService.getIdentificationDocument(employeeEmployment.getEmployee());
        var address = employeeUseCaseService.getAddress(employeeEmployment.getEmployee());

        //values.put("number",order.getNumber() + "-" + order.getOrderType().getSeries());
        values.put("docDate", order.getDate().toString());
        values.put("hrHead",employeeUseCaseService.getLastNameWithInitials(employeeEmploymentUseCaseService.getHrHeadEmployee()));

        values.put("employeeName", employeeUseCaseService.getFullName(employeeEmployment.getEmployee()));
        values.put("employeeTinNumber", employeeEmployment.getEmployee().getTin());

        values.put("departmentName", employment.department().name());
        values.put("employeePosition", employment.position().name());
        values.put("startDate", employment.startDate().toString());

        identificationDocument.ifPresent(identificationDocumentResponse -> {
            values.put("idSeries", identificationDocumentResponse.series());
            values.put("idNumber", identificationDocumentResponse.number().toString());
            values.put("idIssueDate", identificationDocumentResponse.issueDate().toString());
            values.put("idIssuer", identificationDocumentResponse.issueOrganization());
        });

        address.ifPresent(addressResponse -> {
            values.put("employeeAddress", addressResponse.country() + " " + addressResponse.region() + " " + addressResponse.city() + addressResponse + addressResponse.district() + " " + addressResponse.street());

        });
        values.putAll(getSalaryValues(employment));
        values.putAll(getSurchargeValues(employment));
        return values;


       /*
        ${number}
        ${docDate}
        ${branchName}
        ${fullBankName}
        ${fullBankAddress}
          */






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
