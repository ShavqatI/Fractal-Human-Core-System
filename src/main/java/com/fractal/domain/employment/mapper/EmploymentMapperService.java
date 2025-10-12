package com.fractal.domain.employment.mapper;

import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;

public interface EmploymentMapperService {
    EmploymentResponse toDTO(Employment employment);
    Employment toEntity(EmploymentRequest dto);
    //OnlineLearningLocation toEntity(OnlineLearningLocationRequest dto);
    //LearningLocation toEntity(OnlineLearningLocation location, OnlineLearningLocationRequest dto);
}


