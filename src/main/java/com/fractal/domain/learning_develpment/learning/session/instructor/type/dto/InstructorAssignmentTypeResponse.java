package com.fractal.domain.learning_develpment.learning.session.instructor.type.dto;

import java.time.LocalDateTime;

public record InstructorAssignmentTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
