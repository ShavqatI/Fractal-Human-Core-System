package com.fractal.domain.learning_develpment.learning.session.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeResponse;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentResponse;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseResponse;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentResponse;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceResponse;

import java.time.LocalDateTime;
import java.util.List;

public record LearningSessionResponse(
        Long id,
        LearningDeliveryModeResponse learningDeliveryMode,
        LocalDateTime startTime,
        LocalDateTime endTime,
        StatusCompactResponse status,
        List<InstructorAssignmentResponse> instructorAssignments,
        List<LearningSessionEnrollmentResponse> enrollments,
        List<LearningSessionResourceResponse> resources,
        List<LearningSessionExpenseResponse> expenses,
        List<LearningLocationResponse> locations,
        LocalDateTime createdDate
)
{ }
