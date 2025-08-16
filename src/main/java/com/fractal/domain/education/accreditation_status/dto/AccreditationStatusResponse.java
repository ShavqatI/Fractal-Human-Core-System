package com.fractal.domain.education.accreditation_status.dto;

import java.time.LocalDateTime;

public record AccreditationStatusResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
