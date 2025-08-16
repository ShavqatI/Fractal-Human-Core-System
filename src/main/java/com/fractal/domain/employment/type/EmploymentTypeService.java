package com.fractal.domain.employment.type;

import com.fractal.domain.employment.type.dto.EmploymentTypeCompactResponse;
import com.fractal.domain.employment.type.dto.EmploymentTypeRequest;
import com.fractal.domain.employment.type.dto.EmploymentTypeResponse;

import java.util.List;

public interface EmploymentTypeService {

    EmploymentType create(EmploymentTypeRequest dto);
    List<EmploymentType> getAll();
    EmploymentType getByCode(String code);
    EmploymentType getById(Long id);
    EmploymentType update(Long id, EmploymentTypeRequest dto);
    void deleteById(Long id);
    EmploymentTypeResponse toDTO(EmploymentType employmentType);
    EmploymentTypeCompactResponse toCompactDTO(EmploymentType employmentType);
}
