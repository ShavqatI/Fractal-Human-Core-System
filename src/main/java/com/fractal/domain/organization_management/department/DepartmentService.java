package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentCreate;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    Department create(DepartmentCreate dto);
    List<Department> getAll();
    Department getByCode(String code);
    Department getById(Long id);
    Department update(Long id, DepartmentCreate dto);
    void deleteById(Long id);
    DepartmentResponse toDTO(Department department);
}
