package com.fractal.domain.learning_develpment.learning.session.instructor.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;

import java.time.LocalDateTime;

public record InstructorAssignmentResponse(
        Long id,
        InstructorCompactResponse instructor,
        LocalDateTime startTime,
        LocalDateTime endTime,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
