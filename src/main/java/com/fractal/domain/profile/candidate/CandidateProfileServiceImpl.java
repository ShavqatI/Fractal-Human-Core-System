package com.fractal.domain.profile.candidate;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateProfileServiceImpl implements CandidateProfileService {

    private final CandidateService candidateService;
    private final AuthenticatedService authenticatedService;

    @Override
    public Candidate getById() {
        return candidateService.getById(authenticatedService.getCandidateId());
    }

    @Override
    public Candidate update(CandidateRequest dto) {
        return candidateService.update(authenticatedService.getCandidateId(), dto);
    }

    @Override
    public CandidateResponse toDTO(Candidate candidate) {
        return candidateService.toDTO(candidate);
    }

    @Override
    public CandidateCompactResponse toCompactDTO(Candidate candidate) {
        return candidateService.toCompactDTO(candidate);
    }
}
