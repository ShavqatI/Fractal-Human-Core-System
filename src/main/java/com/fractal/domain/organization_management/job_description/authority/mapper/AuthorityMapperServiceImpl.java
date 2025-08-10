package com.fractal.domain.organization_management.job_description.authority.mapper;

import com.fractal.domain.organization_management.job_description.authority.Authority;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityRequest;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuthorityMapperServiceImpl implements AuthorityMapperService {

    @Override
    public AuthorityResponse toDTO(Authority authority) {
        return new AuthorityResponse(
                authority.getId(),
                authority.getDescription(),
                authority.getScope(),
                authority.getCreatedDate()
        );
    }

    @Override
    public Authority toEntity(AuthorityRequest dto) {
        return mapToEntity(new Authority(), dto);
    }

    @Override
    public Authority toEntity(Authority authority, AuthorityRequest dto) {
        return mapToEntity(authority, dto);
    }

    private Authority mapToEntity(Authority authority, AuthorityRequest dto) {
        authority.setDescription(dto.description());
        authority.setScope(dto.scope());
        return authority;
    }
}
