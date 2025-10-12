package com.fractal.domain.employee_management.employee.resource.type;

import com.fractal.domain.employee_management.employee.resource.type.dto.EmployeeResourceTypeRequest;
import com.fractal.domain.employee_management.employee.resource.type.dto.EmployeeResourceTypeResponse;

import java.util.List;

public interface EmployeeResourceTypeService {
   EmployeeResourceType create(EmployeeResourceTypeRequest dto);
   List<EmployeeResourceType> getAll();
   EmployeeResourceType getByCode(String code);
   EmployeeResourceType getById(Long id);
   EmployeeResourceType update(Long id, EmployeeResourceTypeRequest dto);
   void deleteById(Long id);
   EmployeeResourceTypeResponse toDTO(EmployeeResourceType employeeResourceType);
}
