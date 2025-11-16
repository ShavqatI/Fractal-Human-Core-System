package com.fractal.domain.learning_develpment.learning.session.instructor.dto;

import java.time.LocalDateTime;

public record InstructorAssignmentRequest(
        Long instructorId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long statusId

) {
}
