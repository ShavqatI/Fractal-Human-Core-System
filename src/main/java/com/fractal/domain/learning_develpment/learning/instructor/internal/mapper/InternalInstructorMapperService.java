package com.fractal.domain.learning_develpment.learning.instructor.internal.mapper;

import com.fractal.domain.learning_develpment.learning.instructor.Instructor;
import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.internal.InternalInstructor;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorResponse;

public interface InternalInstructorMapperService {
    InternalInstructorResponse toDTO(InternalInstructor instructor);
    InternalInstructorCompactResponse toCompactDTO(InternalInstructor instructor);
    InstructorCompactResponse toCompactDTO(Instructor instructor);
    InternalInstructor toEntity(InternalInstructorRequest dto);
    InternalInstructor toEntity(InternalInstructor instructor, InternalInstructorRequest dto);
}


