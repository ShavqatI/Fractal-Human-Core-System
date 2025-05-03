package com.fractal.domain.organization_management.department;

import java.util.List;

public interface DepartmentService {
    Department create(DepartmentDto dto);
    List<Department> getAll();
    Department getByCode(String code);
    Department getById(Long id);
    Department update(Long id, DepartmentDto dto);
    void deleteById(Long id);
}
