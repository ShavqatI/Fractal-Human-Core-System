package com.fractal.domain.learning_develpment.learning.session.enrollment.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.learning_develpment.learning.learner.LearnerService;
import com.fractal.domain.learning_develpment.learning.session.enrollment.LearningSessionEnrollment;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentRequest;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LearningSessionEnrollmentMapperServiceImpl implements LearningSessionEnrollmentMapperService {

    private final LearnerService learnerService;
    private final StatusService statusService;

    @Override
    public LearningSessionEnrollmentResponse toDTO(LearningSessionEnrollment enrollment) {
        return new LearningSessionEnrollmentResponse(
                enrollment.getId(),
                learnerService.toCompactDTO(enrollment.getLearner()),
                enrollment.getStartTime(),
                enrollment.getEndTime(),
                statusService.toCompactDTO(enrollment.getStatus()),
                enrollment.getCreatedDate()

        );
    }

    @Override
    public LearningSessionEnrollment toEntity(LearningSessionEnrollmentRequest dto) {
        return mapToEntity(new LearningSessionEnrollment(), dto);
    }

    @Override
    public LearningSessionEnrollment toEntity(LearningSessionEnrollment enrollment, LearningSessionEnrollmentRequest dto) {
        return mapToEntity(enrollment, dto);
    }

    private LearningSessionEnrollment mapToEntity(LearningSessionEnrollment learningSessionEnrollment, LearningSessionEnrollmentRequest dto) {
        learningSessionEnrollment.setLearner(learnerService.getById(dto.learnerId()));
        learningSessionEnrollment.setStartTime(dto.startTime());
        learningSessionEnrollment.setEndTime(dto.endTime());
        learningSessionEnrollment.setStatus(statusService.getById(dto.statusId()));
        return learningSessionEnrollment;
    }
}
