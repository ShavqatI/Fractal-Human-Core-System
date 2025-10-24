package com.fractal.domain.organization_management.position.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.grade.dto.GradeCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PositionResponse(
        Long id,
        String name,
        String description,
        DepartmentCompactResponse department,
        GradeCompactResponse grade,
        LocalDate openDate,
        String openReason,
        LocalDate closeDate,
        String closeReason,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {

}
