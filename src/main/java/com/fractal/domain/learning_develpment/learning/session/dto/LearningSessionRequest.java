package com.fractal.domain.learning_develpment.learning.session.dto;

import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentRequest;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseRequest;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceRequest;

import java.time.LocalDateTime;
import java.util.List;

public record LearningSessionRequest(
        Long learningDeliveryModeId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long statusId,
        List<InstructorAssignmentRequest> instructorAssignments,
        List<LearningSessionEnrollmentRequest> enrollments,
        List<LearningSessionResourceRequest> resources,
        List<LearningSessionExpenseRequest> expenses,
        List<LearningLocationRequest> locations

) { }
