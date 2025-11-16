package com.fractal.domain.organization_management.job_description.accountability.mapper;

import com.fractal.domain.organization_management.job_description.accountability.Accountability;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityRequest;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityResponse;

public interface AccountabilityMapperService {
    AccountabilityResponse toDTO(Accountability accountability);

    Accountability toEntity(AccountabilityRequest dto);

    Accountability toEntity(Accountability accountability, AccountabilityRequest dto);
}


