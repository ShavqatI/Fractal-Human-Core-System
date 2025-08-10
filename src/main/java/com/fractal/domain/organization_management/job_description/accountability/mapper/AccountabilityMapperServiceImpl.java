package com.fractal.domain.organization_management.job_description.accountability.mapper;

import com.fractal.domain.organization_management.job_description.accountability.Accountability;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityRequest;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AccountabilityMapperServiceImpl implements AccountabilityMapperService {

    @Override
    public AccountabilityResponse toDTO(Accountability accountability) {
        return new AccountabilityResponse(
                accountability.getId(),
                accountability.getDescription(),
                accountability.getPerformanceMeasure(),
                accountability.getCreatedDate()
        );
    }

    @Override
    public Accountability toEntity(AccountabilityRequest dto) {
        return mapToEntity(new Accountability(), dto);
    }

    @Override
    public Accountability toEntity(Accountability accountability, AccountabilityRequest dto) {
        return mapToEntity(accountability, dto);
    }

    private Accountability mapToEntity(Accountability accountability, AccountabilityRequest dto) {
        accountability.setDescription(dto.description());
        accountability.setPerformanceMeasure(dto.performanceMeasure());
        return accountability;
    }
}
