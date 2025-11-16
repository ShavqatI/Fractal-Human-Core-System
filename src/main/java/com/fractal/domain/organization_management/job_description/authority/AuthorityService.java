package com.fractal.domain.organization_management.job_description.authority;

import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityRequest;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityResponse;

import java.util.List;

public interface AuthorityService {

    Authority create(Long jobDescriptionId, AuthorityRequest dto);

    List<Authority> getAllByJobDescriptionId(Long jobDescriptionId);

    Authority getById(Long jobDescriptionId, Long id);

    Authority update(Long jobDescriptionId, Long id, AuthorityRequest dto);

    void delete(Long jobDescriptionId, Long id);

    AuthorityResponse toDTO(Authority authority);
}
