package com.fractal.domain.learning_develpment.learning.instructor.external.mapper;

import com.fractal.domain.learning_develpment.learning.instructor.external.ExternalInstructor;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorResponse;

public interface ExternalInstructorMapperService {
    ExternalInstructorResponse toDTO(ExternalInstructor instructor);
    ExternalInstructorCompactResponse toCompactDTO(ExternalInstructor instructor);
    ExternalInstructor toEntity(ExternalInstructorRequest dto);
    ExternalInstructor toEntity(ExternalInstructor instructor, ExternalInstructorRequest dto);
}


