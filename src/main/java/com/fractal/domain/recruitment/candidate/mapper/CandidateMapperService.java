package com.fractal.domain.recruitment.candidate.mapper;

import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileRequest;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileResponse;

public interface CandidateMapperService {
    CandidateResponse toDTO(Candidate candidate);
    CandidateCompactResponse toCompactDTO(Candidate candidate);
    CandidateProfileResponse toAccountDTO(Candidate candidate);
    Candidate toEntity(CandidateRequest dto);
    Candidate toEntity(CandidateProfileRequest dto);
    Candidate toEntity(Candidate candidate, CandidateRequest dto);
}


