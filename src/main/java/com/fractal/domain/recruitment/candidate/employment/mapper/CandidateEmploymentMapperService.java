package com.fractal.domain.recruitment.candidate.employment.mapper;

import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.external.dto.ExternalEmploymentResponse;
import com.fractal.domain.recruitment.candidate.employment.CandidateEmployment;

public interface CandidateEmploymentMapperService {
    ExternalEmploymentResponse toDTO(CandidateEmployment employment);

    CandidateEmployment toEntity(ExternalEmploymentRequest dto);

    CandidateEmployment toEntity(CandidateEmployment employment, ExternalEmploymentRequest dto);
}


