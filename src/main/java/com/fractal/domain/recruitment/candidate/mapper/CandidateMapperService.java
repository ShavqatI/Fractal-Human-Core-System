package com.fractal.domain.recruitment.candidate.mapper;

import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;

public interface CandidateMapperService {
    CandidateResponse toDTO(Candidate candidate);
    CandidateCompactResponse toCompactDTO(Candidate candidate);
    Candidate toEntity(CandidateRequest dto);
    Candidate toEntity(Candidate candidate, CandidateRequest dto);
}


