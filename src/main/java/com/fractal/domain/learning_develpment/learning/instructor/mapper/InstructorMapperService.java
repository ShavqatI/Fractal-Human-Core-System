package com.fractal.domain.learning_develpment.learning.instructor.mapper;

import com.fractal.domain.learning_develpment.learning.instructor.Instructor;
import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;

public interface InstructorMapperService {
    //EmploymentResponse toDTO(Learner learner);
    InstructorCompactResponse toCompactDTO(Instructor instructor);
    //Employment toEntity(EmploymentRequest dto);
}


