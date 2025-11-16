package com.fractal.domain.education.degree_type;

import com.fractal.domain.education.degree_type.dto.DegreeTypeRequest;
import com.fractal.domain.education.degree_type.dto.DegreeTypeResponse;

import java.util.List;

public interface DegreeTypeService {

    DegreeType create(DegreeTypeRequest dto);

    List<DegreeType> getAll();

    DegreeType getByCode(String code);

    DegreeType getById(Long id);

    DegreeType update(Long id, DegreeTypeRequest dto);

    void deleteById(Long id);

    DegreeTypeResponse toDTO(DegreeType degreeType);
}
