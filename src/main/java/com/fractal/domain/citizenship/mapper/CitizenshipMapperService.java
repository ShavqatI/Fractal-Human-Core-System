package com.fractal.domain.citizenship.mapper;

import com.fractal.domain.citizenship.Citizenship;
import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;

public interface CitizenshipMapperService {
    CitizenshipResponse toDTO(Citizenship citizenship);
    Citizenship toEntity(CitizenshipRequest dto);
    Citizenship toEntity(Citizenship citizenship, CitizenshipRequest dto);
}


