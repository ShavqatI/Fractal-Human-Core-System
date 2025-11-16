package com.fractal.domain.learning_develpment.learning.instructor.external;

import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorResponse;

import java.util.List;

public interface ExternalInstructorService {
    ExternalInstructor create(ExternalInstructorRequest dto);

    List<ExternalInstructor> getAll();

    ExternalInstructor getById(Long id);

    ExternalInstructor update(Long id, ExternalInstructorRequest dto);

    void deleteById(Long id);

    ExternalInstructorResponse toDTO(ExternalInstructor instructor);

    ExternalInstructorCompactResponse toCompactDTO(ExternalInstructor instructor);

    ExternalInstructor save(ExternalInstructor instructor);


}
