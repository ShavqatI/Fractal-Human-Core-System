package com.fractal.domain.employee_management.employment;

import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;

import java.util.List;

public interface EmployeeEmploymentService {
    EmployeeEmployment create(Long employeeId, EmploymentRequest dto);
    EmployeeEmployment getById(Long employeeId, Long id);
    List<EmployeeEmployment> getAllByEmployeeId(Long employeeId);
    EmployeeEmployment update(Long employeeId, Long id, EmploymentRequest dto);
    void delete(Long employeeId, Long id);
    EmploymentResponse toDTO(EmployeeEmployment employment);

}
