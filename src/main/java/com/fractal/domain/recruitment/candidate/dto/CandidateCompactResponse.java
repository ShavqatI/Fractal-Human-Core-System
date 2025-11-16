package com.fractal.domain.recruitment.candidate.dto;

import java.time.LocalDate;

public record CandidateCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName,
        LocalDate birthDate,
        String tin,
        String ssn,
        String gender,
        String maritalStatus,
        String nationality
) {
}
