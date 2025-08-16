package com.fractal.domain.recruitment.candidate;

import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;

import java.util.List;

public interface CandidateService {
    Candidate create(CandidateRequest dto);
    List<Candidate> getAll();
    Candidate getById(Long id);
    Candidate update(Long id, CandidateRequest dto);
    void deleteById(Long id);
    CandidateResponse toDTO(Candidate candidate);
    CandidateCompactResponse toCompactDTO(Candidate candidate);
    Candidate save(Candidate candidate);


}
