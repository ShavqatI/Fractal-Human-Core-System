package com.fractal.domain.learning_develpment.learning.instructor.internal.dto;

import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;

public record InternalInstructorCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) implements InstructorCompactResponse { }
