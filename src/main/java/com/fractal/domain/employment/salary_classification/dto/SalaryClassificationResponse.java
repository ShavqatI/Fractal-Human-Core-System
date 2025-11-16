package com.fractal.domain.employment.salary_classification.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;
import java.util.List;

public record SalaryClassificationResponse(
        Long id,
        String code,
        String name,
        String parent,
        List<SalaryClassificationResponse> children,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
