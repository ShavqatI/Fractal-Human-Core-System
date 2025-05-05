package com.fractal.domain.organization_management.job_description.responsibility;

import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;
import org.springframework.stereotype.Service;

@Service
class ResponsibilityServiceImpl implements ResponsibilityService  {
    @Override
    public ResponsibilityResponse toDTO(Responsibility responsibility) {
        return new ResponsibilityResponse(
                responsibility.getId(),
                responsibility.getDescription(),
                responsibility.getCreatedDate()
        );
    }

    @Override
    public Responsibility toEntity(ResponsibilityRequest dto) {
        return Responsibility.builder().description(dto.description()).build();
    }
}
