package com.fractal.domain.recruitment.candidate.military_service.mapper;

import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.recruitment.candidate.military_service.CandidateMilitaryService;

public interface CandidateMilitaryServiceMapperService {
    MilitaryServiceResponse toDTO(CandidateMilitaryService militaryService);

    CandidateMilitaryService toEntity(MilitaryServiceRequest dto);

    CandidateMilitaryService toEntity(CandidateMilitaryService militaryService, MilitaryServiceRequest dto);
}


