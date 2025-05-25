package com.fractal.domain.employee_management.employment.type;

import com.fractal.domain.employee_management.employment.type.dto.EmploymentTypeRequest;
import com.fractal.domain.employee_management.employment.type.dto.EmploymentTypeResponse;
import com.fractal.domain.employee_management.identification_document.type.IdentificationDocumentType;
import com.fractal.domain.employee_management.identification_document.type.dto.IdentificationDocumentTypeRequest;
import com.fractal.domain.employee_management.identification_document.type.dto.IdentificationDocumentTypeResponse;

import java.util.List;

public interface EmploymentTypeService {

    EmploymentType create(EmploymentTypeRequest dto);
    List<EmploymentType> getAll();
    EmploymentType getByCode(String code);
    EmploymentType getById(Long id);
    EmploymentType update(Long id, EmploymentTypeRequest dto);
    void deleteById(Long id);
    EmploymentTypeResponse toDTO(EmploymentType employmentType);
}
