package com.fractal.domain.learning_develpment.learning.session.enrollment;


import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentRequest;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentResponse;

import java.util.List;
public interface LearningSessionEnrollmentService {

    LearningSessionEnrollment create(Long sessionId, LearningSessionEnrollmentRequest dto);
    List<LearningSessionEnrollment> getAllByLearningSessionId(Long sessionId);
    LearningSessionEnrollment getById(Long sessionId , Long id);
    LearningSessionEnrollmentResponse toDTO(LearningSessionEnrollment enrollment);
    LearningSessionEnrollment update(Long sessionId, Long id, LearningSessionEnrollmentRequest dto);
    void delete(Long sessionId,Long id);


}
