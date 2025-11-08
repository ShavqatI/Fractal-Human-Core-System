package com.fractal.domain.integration.mapping.employee;

import com.fractal.domain.integration.mapping.employee.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.integration.mapping.employee.dto.DocumentTemplateManagerResponse;

import java.util.List;

public interface DocumentTemplateManagerService {

    EmployeeMapping create(DocumentTemplateManagerRequest dto);
    List<EmployeeMapping> getAll();
    EmployeeMapping getByCode(String code);
    EmployeeMapping getById(Long id);
    EmployeeMapping update(Long id, DocumentTemplateManagerRequest dto);
    void deleteById(Long id);
    DocumentTemplateManagerResponse toDTO(EmployeeMapping employeeMapping);
}
