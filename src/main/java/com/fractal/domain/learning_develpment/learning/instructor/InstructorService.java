package com.fractal.domain.learning_develpment.learning.instructor;

import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;

public interface InstructorService {
    Instructor getById(Long id);
    InstructorCompactResponse toCompactDTO(Instructor instructor);
}
