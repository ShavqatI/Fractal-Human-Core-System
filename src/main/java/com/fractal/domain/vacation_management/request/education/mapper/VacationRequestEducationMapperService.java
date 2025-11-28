package com.fractal.domain.vacation_management.request.education.mapper;

import com.fractal.domain.education.Education;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.vacation_management.request.education.VacationRequestEducation;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationRequest;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationResponse;


public interface VacationRequestEducationMapperService {
    VacationRequestEducationResponse toDTO(VacationRequestEducation education);

    VacationRequestEducation toEntity(VacationRequestEducationRequest dto);

    VacationRequestEducation toEntity(VacationRequestEducation education, VacationRequestEducationRequest dto);
}


