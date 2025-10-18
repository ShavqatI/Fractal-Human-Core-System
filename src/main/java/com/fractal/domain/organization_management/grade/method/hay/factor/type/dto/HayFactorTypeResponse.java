package com.fractal.domain.organization_management.grade.method.hay.factor.type.dto;

import java.time.LocalDateTime;
import java.util.List;

public record HayFactorTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        List<HayFactorTypeResponse> children,
        LocalDateTime createdDate

) {

}
