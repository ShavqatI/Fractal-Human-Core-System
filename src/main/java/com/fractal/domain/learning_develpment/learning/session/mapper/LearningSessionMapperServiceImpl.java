package com.fractal.domain.learning_develpment.learning.session.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.learning_develpment.learning.delivery_mode.LearningDeliveryModeService;
import com.fractal.domain.learning_develpment.learning.session.location.mapper.LearningLocationMapperService;
import com.fractal.domain.learning_develpment.learning.session.LearningSession;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionCompactResponse;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionRequest;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionResponse;
import com.fractal.domain.learning_develpment.learning.session.enrollment.mapper.LearningSessionEnrollmentMapperService;
import com.fractal.domain.learning_develpment.learning.session.expense.mapper.LearningSessionExpenseMapperService;
import com.fractal.domain.learning_develpment.learning.session.instructor.mapper.InstructorAssignmentMapperService;
import com.fractal.domain.learning_develpment.learning.session.resource.mapper.LearningSessionResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class LearningSessionMapperServiceImpl implements LearningSessionMapperService {


    private final LearningDeliveryModeService deliveryModeService;
    private final InstructorAssignmentMapperService instructorAssignmentMapperService;
    private final LearningSessionEnrollmentMapperService enrollmentMapperService;
    private final LearningSessionResourceMapperService resourceMapperService;
    private final LearningSessionExpenseMapperService expenseMapperService;
    private final LearningLocationMapperService locationMapperService;

    private final StatusService statusService;
    @Override
    public LearningSessionResponse toDTO(LearningSession session) {
        return new LearningSessionResponse(
                session.getId(),
                deliveryModeService.toDTO(session.getDeliveryMode()),
                session.getStartTime(),
                session.getEndTime(),
                statusService.toCompactDTO(session.getStatus()),
                Optional.ofNullable(session.getInstructorAssignments())
                        .orElse(emptyList())
                        .stream()
                        .map(instructorAssignmentMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(session.getEnrollments())
                        .orElse(emptyList())
                        .stream()
                        .map(enrollmentMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(session.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(session.getExpenses())
                        .orElse(emptyList())
                        .stream()
                        .map(expenseMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(session.getLocations())
                        .orElse(emptyList())
                        .stream()
                        .map(locationMapperService::toDTO)
                        .collect(Collectors.toList()),
                session.getCreatedDate()

        );
    }

    @Override
    public LearningSessionCompactResponse toCompactDTO(LearningSession session) {
        return new LearningSessionCompactResponse(
                session.getId(),
                deliveryModeService.toDTO(session.getDeliveryMode()),
                session.getStartTime(),
                session.getEndTime(),
                statusService.toCompactDTO(session.getStatus())
        );
    }

    @Override
    public LearningSession toEntity(LearningSessionRequest dto) {
        return mapToEntity(new LearningSession(), dto);
    }

    @Override
    public LearningSession toEntity(LearningSession learningSession, LearningSessionRequest dto) {
        return mapToEntity(learningSession, dto);
    }

    private LearningSession mapToEntity(LearningSession session, LearningSessionRequest dto) {
        session.setDeliveryMode(deliveryModeService.getById(dto.learningDeliveryModeId()));
        session.setStartTime(dto.startTime());
        session.setEndTime(dto.endTime());
        session.setStatus(statusService.getById(dto.statusId()));
        dto.instructorAssignments().forEach(instructorAssignment-> session.addInstructorAssignment(instructorAssignmentMapperService.toEntity(instructorAssignment)));
        dto.enrollments().forEach(enrollment-> session.addEnrollment(enrollmentMapperService.toEntity(enrollment)));
        dto.resources().forEach(resource-> session.addResource(resourceMapperService.toEntity(resource,null)));
        dto.expenses().forEach(expense-> session.addExpense(expenseMapperService.toEntity(expense)));
        dto.locations().forEach(location-> session.addLocation(locationMapperService.toEntity(location)));
        return session;
    }
}
