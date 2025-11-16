package com.fractal.domain.organization_management.grade.method.hay.factor.mapper;

import com.fractal.domain.organization_management.grade.method.hay.factor.HayFactor;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorResponse;

public interface HayFactorMapperService {
    HayFactorResponse toDTO(HayFactor factor);

    HayFactorCompactResponse toCompactDTO(HayFactor factor);

    HayFactor toEntity(HayFactorRequest dto);

    HayFactor toEntity(HayFactor factor, HayFactorRequest dto);
}


