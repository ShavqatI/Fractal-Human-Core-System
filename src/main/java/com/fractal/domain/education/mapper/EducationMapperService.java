package com.fractal.domain.education.mapper;

import com.fractal.domain.education.Education;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.identification_document.IdentificationDocument;

public interface EducationMapperService {
    EducationResponse toDTO(Education education);
    Education toEntity(EducationRequest dto);
    Education toEntity(Education education, EducationRequest dto);
    Education copy(Education education);
}


