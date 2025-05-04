package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    Department create(DepartmentRequest dto);
    List<Department> getAll();
    Department getByCode(String code);
    Department getById(Long id);
    Department update(Long id, DepartmentRequest dto);
    void deleteById(Long id);
    DepartmentResponse toDTO(Department department);
}
