package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    Department create(DepartmentRequest dto);
    List<Department> getAll();
    List<Department> getAllTopLevel();
    Department getByCode(String code);
    Department getById(Long id);
    Department update(Long id, DepartmentRequest dto);
    void deleteById(Long id);
    DepartmentResponse toDTO(Department department);
    DepartmentCompactResponse toCompactDTO(Department department);
    Department addChild(Long id, DepartmentRequest dto);
    Department updateChild(Long id,Long childId,DepartmentRequest dto);
    Department deleteChild(Long id,Long childId);
}
