package com.fractal.domain.organization_management.job_description.responsibility;

import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;

public interface ResponsibilityService {

    ResponsibilityResponse toDTO(Responsibility responsibility);
    Responsibility toEntity(ResponsibilityRequest dto);
}
