package com.fractal.domain.employment.work_experience.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employment.type.dto.EmploymentTypeCompactResponse;
import com.fractal.domain.location.country.dto.CountryCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record WorkExperienceResponse(
        Long id,
        CountryCompactResponse country,
        String location,
        EmploymentTypeCompactResponse employmentType,
        LocalDate startDate,
        LocalDate endDate,
        String organization,
        String department,
        String division,
        String position,
        String responsibilities,
        String achievements,
        String leaveReason,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }