package com.fractal.domain.organization_management.grade.method.hay.factor.dto;

import com.fractal.domain.dictionary.measurement_unit.dto.MeasurementUnitResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeCompactResponse;

import java.time.LocalDateTime;

public record HayFactorResponse(
        Long id,
        HayFactorTypeCompactResponse factorType,
        MeasurementUnitResponse measurementUnit,
        String code,
        String name,
        String description,
        Double minPoint,
        Double maxPoint,
        Double weight,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
