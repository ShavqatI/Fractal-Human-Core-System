package com.fractal.domain.recruitment.candidate.citizenship.mapper;

import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenship;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipRequest;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipResponse;

public interface CandidateCitizenshipMapperService {
    CandidateCitizenshipResponse toDTO(CandidateCitizenship candidateCitizenship);
    CandidateCitizenship toEntity(CandidateCitizenshipRequest dto);
    CandidateCitizenship toEntity(CandidateCitizenship candidateCitizenship, CandidateCitizenshipRequest dto);
}


