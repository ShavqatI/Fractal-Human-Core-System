package com.fractal.domain.employment.external.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonResponse;
import com.fractal.domain.employment.type.dto.EmploymentTypeCompactResponse;
import com.fractal.domain.location.country.dto.CountryCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ExternalEmploymentResponse(
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
        List<SeparationReasonResponse> separationReasons,
        StatusCompactResponse status,
        LocalDateTime createdDate

) implements EmploymentResponse { }
