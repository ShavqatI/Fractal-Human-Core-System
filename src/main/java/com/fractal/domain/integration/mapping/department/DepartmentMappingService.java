package com.fractal.domain.integration.mapping.department;

import com.fractal.domain.integration.mapping.department.dto.DepartmentMappingRequest;
import com.fractal.domain.integration.mapping.department.dto.DepartmentMappingResponse;

import java.util.List;

public interface DepartmentMappingService {

    DepartmentMapping create(DepartmentMappingRequest dto);
    List<DepartmentMapping> getAll();
    DepartmentMapping getById(Long id);
    DepartmentMapping update(Long id, DepartmentMappingRequest dto);
    void deleteById(Long id);
    DepartmentMappingResponse toDTO(DepartmentMapping departmentMapping);
}
