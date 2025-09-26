package com.fractal.domain.learning_develpment.learning.instructor.external.dto;

public record ExternalInstructorCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {
}
