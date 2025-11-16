package com.fractal.domain.employee_management.education;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;

import java.util.List;


public interface EmployeeEducationService {
    EmployeeEducation create(Long employeeId, EducationRequest dto);

    List<EmployeeEducation> getAllByEmployeeId(Long employeeId);

    EmployeeEducation getById(Long employeeId, Long id);

    EmployeeEducation getById(Long id);

    EmployeeEducation update(Long id, Long educationId, EducationRequest dto);

    void delete(Long employeeId, Long id);

    EducationResponse toDTO(EmployeeEducation employeeEducation);
}
