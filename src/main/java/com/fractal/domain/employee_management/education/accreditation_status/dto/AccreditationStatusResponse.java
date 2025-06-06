package com.fractal.domain.employee_management.education.accreditation_status.dto;

import java.time.LocalDateTime;

public record AccreditationStatusResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
