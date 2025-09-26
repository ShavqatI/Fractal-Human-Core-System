package com.fractal.domain.learning_develpment.learning.instructor.dto;

public record InstructorCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {
}
