package com.fractal.domain.education.type;

import com.fractal.domain.education.type.dto.EducationTypeRequest;
import com.fractal.domain.education.type.dto.EducationTypeResponse;

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
