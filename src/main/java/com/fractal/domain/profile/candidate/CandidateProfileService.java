package com.fractal.domain.profile.candidate;

import com.fractal.domain.profile.candidate.dto.CandidateProfileCreateRequest;
import com.fractal.domain.profile.candidate.dto.CandidateProfileResponse;
import com.fractal.domain.profile.candidate.dto.CandidateProfileUpdateRequest;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;

public interface CandidateProfileService {
    Candidate create(CandidateProfileCreateRequest dto);
    Candidate getById();
    Candidate update(CandidateProfileUpdateRequest dto);
    CandidateResponse toDTO(Candidate candidate);
    CandidateCompactResponse toCompactDTO(Candidate candidate);
    CandidateProfileResponse toProfileDTO(Candidate candidate);
}
