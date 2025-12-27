package com.fractal.domain.agreement.employment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.authorization.mapping.user_employee.UserEmployeeMappingService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.order.employment.EmploymentOrder;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.address.OrganizationAddressService;
import com.fractal.domain.utility.converter.NumberToWordConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class AgreementTemplateProcessorService {

    private final EmployeeEmploymentService employeeEmploymentService;
    private final OrganizationService organizationService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final EmployeeEmploymentUseCaseService employeeEmploymentUseCaseService;
    private final OrganizationAddressService organizationAddressService;
    private final AuthenticatedService authenticatedService;
    private final UserEmployeeMappingService userEmployeeMappingService;




    public Map<String,String> process(EmploymentAgreement agreement){
        var employeeEmployment = getEmployment(agreement);
        return switch (employeeEmployment.getEmployment().getEmploymentType().getCode()) {
            case "PERMANENT" -> getPermanentValues(agreement);
            case "CONTRACT" -> getContractServiceValues(agreement);
            default -> new HashMap<>();
        };
    }

    private Map<String,String> getPermanentValues(EmploymentAgreement agreement) {
        var employeeEmployment = getEmployment(agreement);
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(agreement)).get();
        var identificationDocument = employeeUseCaseService.getIdentificationDocument(employeeEmployment.getEmployee());
        var address = employeeUseCaseService.getAddress(employeeEmployment.getEmployee());
        var headOffice = organizationService.getHeadOffice();
        var headOfficeAddress = organizationAddressService.toDTO(organizationService.getActiveAddress(headOffice));

        //values.put("number",order.getNumber() + "-" + order.getOrderType().getSeries());
        values.put("docDate", agreement.getDate().toString());
        values.put("hrHead",employeeUseCaseService.getLastNameWithInitials(employeeEmploymentUseCaseService.getHrHeadEmployee()));
        getCurrentUserEmployeeEmployment().ifPresent(x-> values.put("branchName",x.organization().name()));


        values.put("fullBankName",headOffice.getFullName());
        values.put("fullBankAddress", headOfficeAddress.country() + " " + headOfficeAddress.region() + " " + headOfficeAddress.city() + headOfficeAddress.district() + " " + headOfficeAddress.street());

        values.put("employeeName", employeeUseCaseService.getFullName(employeeEmployment.getEmployee()));
        values.put("employeeTinNumber", employeeEmployment.getEmployee().getTin());
        values.put("departmentName", employment.department().name());
        values.put("employeePosition", employment.position().name());
        values.put("startDate", employment.startDate().toString());
        values.put("endDate", employment.endDate().toString());

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
          */
    }
    private Map<String,String> getContractServiceValues(EmploymentAgreement agreement) {
        Map<String,String> values = new HashMap<>();
        var employment = employeeEmploymentService.getEmployment(getEmployment(agreement)).get();

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

    private EmployeeEmployment getEmployment(EmploymentAgreement agreement){
        return employeeEmploymentService.getByEmploymentId(agreement.getEmployment().getId());
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

    private Optional<InternalEmploymentResponse> getCurrentUserEmployeeEmployment() {
        if(authenticatedService.getUser() != null) {
            var employee = userEmployeeMappingService.getEmployee(authenticatedService.getUser());
            return employeeUseCaseService.getCurrentEmployment(employee);
        }
        return Optional.empty();
    }

}
