package com.fractal.domain.learning_develpment.learning.instructor.internal;

import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorResponse;

import java.util.List;

public interface InternalInstructorService {
    InternalInstructor create(InternalInstructorRequest dto);
    List<InternalInstructor> getAll();
    InternalInstructor getById(Long id);
    InternalInstructor update(Long id, InternalInstructorRequest dto);
    void deleteById(Long id);
    InternalInstructorResponse toDTO(InternalInstructor instructor);
    InternalInstructorCompactResponse toCompactDTO(InternalInstructor instructor);


}
