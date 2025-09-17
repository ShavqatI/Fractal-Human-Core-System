package com.fractal.domain.insurance.provider.mapper;

import com.fractal.domain.insurance.provider.InsuranceProvider;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderCompactResponse;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderRequest;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderResponse;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;

public interface InsuranceProviderMapperService {
    InsuranceProviderResponse toDTO(InsuranceProvider insuranceProvider);
    InsuranceProviderCompactResponse toCompactDTO(InsuranceProvider insuranceProvider);
    InsuranceProvider toEntity(InsuranceProviderRequest dto);
    InsuranceProvider toEntity(InsuranceProvider insuranceProvider, InsuranceProviderRequest dto);
}


