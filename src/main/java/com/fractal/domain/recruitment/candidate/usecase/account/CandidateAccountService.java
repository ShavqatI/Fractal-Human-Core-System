package com.fractal.domain.recruitment.candidate.usecase.account;

import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountRequest;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountResponse;

public interface CandidateAccountService {
  Candidate create(CandidateAccountRequest dto);
  CandidateAccountResponse toDTO(Candidate candidate);
}
