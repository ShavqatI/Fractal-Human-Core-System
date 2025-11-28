package com.fractal.domain.vacation_management.request.education.dto;

import java.time.LocalDate;

public record VacationRequestEducationRequest(

        LocalDate beginDate,
        LocalDate endDate,
        String institutionName,
        String institutionAddress,
        Boolean isForeignInstitution,
        String specialization
) { }
