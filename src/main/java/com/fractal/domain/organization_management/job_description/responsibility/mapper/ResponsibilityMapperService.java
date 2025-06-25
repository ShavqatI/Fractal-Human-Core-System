package com.fractal.domain.organization_management.job_description.responsibility.mapper;

import com.fractal.domain.organization_management.job_description.responsibility.Responsibility;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;

public interface ResponsibilityMapperService {
    ResponsibilityResponse toDTO(Responsibility responsibility);
    Responsibility toEntity(ResponsibilityRequest dto);
    Responsibility toEntity(Responsibility responsibility, ResponsibilityRequest dto);
}


