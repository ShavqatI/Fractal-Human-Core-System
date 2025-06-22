package com.fractal.domain.employee_management.employee.mapper;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.identification_document.IdentificationDocument;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;

public interface EmployeeMapperService {
    EmployeeResponse toDTO(Employee employee);
    Employee toEntity(EmployeeRequest dto);
    Employee toEntity(Employee employee, EmployeeRequest dto);
}


