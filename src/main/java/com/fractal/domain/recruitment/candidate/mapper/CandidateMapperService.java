package com.fractal.domain.recruitment.candidate.mapper;

import com.fractal.domain.profile.candidate.dto.CandidateProfileCreateRequest;
import com.fractal.domain.profile.candidate.dto.CandidateProfileResponse;
import com.fractal.domain.profile.candidate.dto.CandidateProfileUpdateRequest;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;

public interface CandidateMapperService {
    CandidateResponse toDTO(Candidate candidate);
    CandidateCompactResponse toCompactDTO(Candidate candidate);
    CandidateProfileResponse toProfileDTO(Candidate candidate);
    Candidate toEntity(CandidateRequest dto);
    Candidate toEntity(CandidateProfileCreateRequest dto);
    Candidate toEntity(Candidate candidate, CandidateRequest dto);
    Candidate toEntity(Candidate candidate, CandidateProfileUpdateRequest dto);
    Candidate toEntity(Candidate candidate, CandidateProfileCreateRequest dto);
}


