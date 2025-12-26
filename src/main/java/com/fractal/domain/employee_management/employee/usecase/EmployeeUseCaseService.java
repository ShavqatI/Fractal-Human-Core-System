package com.fractal.domain.employee_management.employee.usecase;

import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.location.address.dto.AddressResponse;

import java.util.Optional;

public interface EmployeeUseCaseService {

    String getFullName(Employee employee);
    String getLastNameWithInitials(Employee employee);
    Optional<InternalEmploymentResponse> getCurrentEmployment(Employee employee);
    Optional<IdentificationDocumentResponse> getIdentificationDocument(Employee employee);
    Optional<EmployeeAddressResponse> getAddress(Employee employee);


}
