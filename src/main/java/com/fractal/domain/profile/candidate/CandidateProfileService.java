package com.fractal.domain.profile.candidate;

import com.fractal.domain.profile.candidate.dto.CandidateProfileRequest;
import com.fractal.domain.profile.candidate.dto.CandidateProfileResponse;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;

public interface CandidateProfileService {
    Candidate create(CandidateProfileRequest dto);
    Candidate getById();
    Candidate update(CandidateProfileRequest dto);
    CandidateResponse toDTO(Candidate candidate);
    CandidateCompactResponse toCompactDTO(Candidate candidate);
    CandidateProfileResponse toProfileDTO(Candidate candidate);
}
