package com.fractal.domain.recruitment.candidate.mapper;

import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountRequest;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountResponse;

public interface CandidateMapperService {
    CandidateResponse toDTO(Candidate candidate);
    CandidateCompactResponse toCompactDTO(Candidate candidate);
    CandidateAccountResponse toAccountDTO(Candidate candidate);
    Candidate toEntity(CandidateRequest dto);
    Candidate toEntity(CandidateAccountRequest dto);
    Candidate toEntity(Candidate candidate, CandidateRequest dto);
}


