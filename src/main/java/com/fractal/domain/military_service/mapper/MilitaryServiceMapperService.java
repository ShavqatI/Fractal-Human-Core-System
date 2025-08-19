package com.fractal.domain.military_service.mapper;

import com.fractal.domain.military_service.MilitaryService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;

public interface MilitaryServiceMapperService {
    MilitaryServiceResponse toDTO(MilitaryService militaryService);
    MilitaryService toEntity(MilitaryServiceRequest dto);
    MilitaryService toEntity(MilitaryService militaryService, MilitaryServiceRequest dto);
}


