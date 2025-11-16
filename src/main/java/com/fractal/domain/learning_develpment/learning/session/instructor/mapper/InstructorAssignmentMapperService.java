package com.fractal.domain.learning_develpment.learning.session.instructor.mapper;

import com.fractal.domain.learning_develpment.learning.session.instructor.InstructorAssignment;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentRequest;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentResponse;

public interface InstructorAssignmentMapperService {
    InstructorAssignmentResponse toDTO(InstructorAssignment instructorAssignment);

    InstructorAssignment toEntity(InstructorAssignmentRequest dto);

    InstructorAssignment toEntity(InstructorAssignment instructorAssignment, InstructorAssignmentRequest dto);
}


