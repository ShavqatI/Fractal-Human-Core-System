package com.fractal.domain.learning_develpment.learning.session.enrollment.mapper;

import com.fractal.domain.learning_develpment.learning.session.enrollment.LearningSessionEnrollment;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentRequest;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentResponse;

public interface LearningSessionEnrollmentMapperService {
    LearningSessionEnrollmentResponse toDTO(LearningSessionEnrollment enrollment);

    LearningSessionEnrollment toEntity(LearningSessionEnrollmentRequest dto);

    LearningSessionEnrollment toEntity(LearningSessionEnrollment enrollment, LearningSessionEnrollmentRequest dto);
}


