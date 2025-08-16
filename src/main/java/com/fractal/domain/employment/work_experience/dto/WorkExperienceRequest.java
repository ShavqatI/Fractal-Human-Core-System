package com.fractal.domain.employment.work_experience.dto;

import java.time.LocalDate;

public record WorkExperienceRequest(
        Long countryId,
        String location,
        Long employmentTypeId,
        LocalDate startDate,
        LocalDate endDate,
        String organization,
        String department,
        String division,
        String position,
        String responsibilities,
        String achievements,
        String leaveReason,
        Long statusId
) {
}
