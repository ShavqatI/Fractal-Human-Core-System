package com.fractal.domain.employee_management.education.type;

import com.fractal.domain.employee_management.education.type.dto.EducationTypeRequest;
import com.fractal.domain.employee_management.education.type.dto.EducationTypeResponse;
import com.fractal.domain.employee_management.employment.type.dto.EmploymentTypeRequest;
import com.fractal.domain.employee_management.employment.type.dto.EmploymentTypeResponse;

import java.util.List;

public interface EducationTypeService {

    EducationType create(EducationTypeRequest dto);
    List<EducationType> getAll();
    EducationType getByCode(String code);
    EducationType getById(Long id);
    EducationType update(Long id, EducationTypeRequest dto);
    void deleteById(Long id);
    EducationTypeResponse toDTO(EducationType educationType);
}
