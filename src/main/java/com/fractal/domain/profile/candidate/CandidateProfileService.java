package com.fractal.domain.profile.candidate;

import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;

import java.util.List;

public interface CandidateProfileService {
    Candidate getById();
    Candidate update(CandidateRequest dto);
    CandidateResponse toDTO(Candidate candidate);
    CandidateCompactResponse toCompactDTO(Candidate candidate);
}
