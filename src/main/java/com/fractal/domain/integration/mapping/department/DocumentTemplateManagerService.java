package com.fractal.domain.integration.mapping.department;

import com.fractal.domain.integration.mapping.department.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.integration.mapping.department.dto.DocumentTemplateManagerResponse;

import java.util.List;

public interface DocumentTemplateManagerService {

    DepartmentMapping create(DocumentTemplateManagerRequest dto);
    List<DepartmentMapping> getAll();
    DepartmentMapping getByCode(String code);
    DepartmentMapping getById(Long id);
    DepartmentMapping update(Long id, DocumentTemplateManagerRequest dto);
    void deleteById(Long id);
    DocumentTemplateManagerResponse toDTO(DepartmentMapping departmentMapping);
}
