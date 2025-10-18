package com.fractal.domain.organization_management.grade.method.hay.factor.dto;

public record HayFactorRequest(
        Long factorTypeId,

        Long measurementUnitId,
        String code,
        String name,
        String description,
        Double minPoint,
        Double maxPoint,
        Double weight,
        Long statusId
) {
}
