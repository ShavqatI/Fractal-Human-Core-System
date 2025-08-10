package com.fractal.domain.organization_management.job_description.authority.mapper;

import com.fractal.domain.organization_management.job_description.authority.Authority;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityRequest;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityResponse;

public interface AuthorityMapperService {
    AuthorityResponse toDTO(Authority authority);
    Authority toEntity(AuthorityRequest dto);
    Authority toEntity(Authority authority, AuthorityRequest dto);
}


