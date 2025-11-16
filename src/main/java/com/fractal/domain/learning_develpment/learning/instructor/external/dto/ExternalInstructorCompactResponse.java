package com.fractal.domain.learning_develpment.learning.instructor.external.dto;

import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;

public record ExternalInstructorCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) implements InstructorCompactResponse {
}
