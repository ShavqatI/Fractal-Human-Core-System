package com.fractal.domain.organization_management.job_description.responsibility.mapper;

import com.fractal.domain.organization_management.job_description.responsibility.Responsibility;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ResponsibilityMapperServiceImpl implements ResponsibilityMapperService {

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
        return mapToEntity(new Responsibility(), dto);
    }

    @Override
    public Responsibility toEntity(Responsibility responsibility, ResponsibilityRequest dto) {
        return mapToEntity(responsibility, dto);
    }

    private Responsibility mapToEntity(Responsibility responsibility, ResponsibilityRequest dto) {
        responsibility.setDescription(dto.description());
        return responsibility;
    }
}
