package com.fractal.domain.employee_management.employee.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocumentService;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class EmployeeUseCaseServiceImpl implements EmployeeUseCaseService {
    private final EmployeeEmploymentService employeeEmploymentService;
    private final InternalEmploymentService internalEmploymentService;
    private final EmployeeIdentificationDocumentService identificationDocumentService;
    @Override
    public String getFullName(Employee employee) {
        if(employee == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(employee.getLastName() + " ");
        sb.append(employee.getFirstName() + " ");
        sb.append(employee.getPatronymicName());
        return sb.toString();
    }

    @Override
    public String getLastNameWithInitials(Employee employee) {
        if(employee == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(employee.getLastName()).append(" ");
        sb.append(employee.getFirstName().substring(0,1)).append(". ");
        sb.append(employee.getPatronymicName().substring(0,1)).append(".");
        return sb.toString();
    }

    @Override
    public Optional<InternalEmploymentResponse> getCurrentEmployment(Employee employee) {
        var employeeEmployment = employeeEmploymentService.getActiveEmployment(employee.getId());
        var employment  = (Employment) Hibernate.unproxy(employeeEmployment.getEmployment());
        if(employeeEmployment != null && employment instanceof InternalEmployment internalEmployment){
            return Optional.ofNullable(internalEmploymentService.toDTO(internalEmployment));
        }
        return Optional.empty();
    }

    @Override
    public Optional<IdentificationDocumentResponse> getIdentificationDocument(Employee employee) {
        var identificationDocument = identificationDocumentService.getAllByEmployeeId(employee.getId())
                .stream().filter(id-> id.getStatus().getCode().equals("ACTIVE")
                        &&
                        (id.getIdentificationDocumentType().getCode().equals("ID")
                        || id.getIdentificationDocumentType().getCode().equals("PASSPORT")
                        )

                ).findAny();
        if(identificationDocument.isPresent())
            return Optional.of(identificationDocumentService.toDTO(identificationDocument.get()));
        return Optional.empty();
    }


}
