package com.fractal.domain.recruitment.candidate.usecase.profile;

import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileRequest;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileResponse;

public interface CandidateProfileService {
  Candidate create(CandidateProfileRequest dto);
  CandidateProfileResponse toDTO(Candidate candidate);
}
