package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentCreateDto;
import com.fractal.domain.organization_management.department.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    Department create(DepartmentCreateDto dto);
    List<Department> getAll();
    Department getByCode(String code);
    Department getById(Long id);
    Department update(Long id, DepartmentCreateDto dto);
    void deleteById(Long id);

    DepartmentResponseDto toDTO(Department department);
}
