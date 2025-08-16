package com.fractal.domain.recruitment.candidate.citizenship.mapper;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenship;

public interface CandidateCitizenshipMapperService {
    CitizenshipResponse toDTO(CandidateCitizenship citizenship);
    CandidateCitizenship toEntity(CitizenshipRequest dto);
    CandidateCitizenship toEntity(CandidateCitizenship citizenship, CitizenshipRequest dto);
}


