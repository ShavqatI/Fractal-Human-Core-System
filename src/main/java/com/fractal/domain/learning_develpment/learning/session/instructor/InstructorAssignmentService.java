package com.fractal.domain.learning_develpment.learning.session.instructor;


import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentRequest;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentResponse;

import java.util.List;

public interface InstructorAssignmentService {

    InstructorAssignment create(Long sessionId, InstructorAssignmentRequest dto);

    List<InstructorAssignment> getAllByLearningSessionId(Long sessionId);

    InstructorAssignment getById(Long sessionId, Long id);

    InstructorAssignmentResponse toDTO(InstructorAssignment instructorAssignment);

    InstructorAssignment update(Long sessionId, Long id, InstructorAssignmentRequest dto);

    void delete(Long sessionId, Long id);


}
