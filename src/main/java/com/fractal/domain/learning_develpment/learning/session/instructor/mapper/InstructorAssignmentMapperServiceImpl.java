package com.fractal.domain.learning_develpment.learning.session.instructor.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.learning_develpment.learning.instructor.InstructorService;
import com.fractal.domain.learning_develpment.learning.session.instructor.InstructorAssignment;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentRequest;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InstructorAssignmentMapperServiceImpl implements InstructorAssignmentMapperService {

    private final InstructorService instructorService;
    private final StatusService statusService;

    @Override
    public InstructorAssignmentResponse toDTO(InstructorAssignment instructorAssignment) {
        return new InstructorAssignmentResponse(
                instructorAssignment.getId(),
                instructorService.toCompactDTO(instructorAssignment.getInstructor()),
                instructorAssignment.getStartTime(),
                instructorAssignment.getEndTime(),
                statusService.toCompactDTO(instructorAssignment.getStatus()),
                instructorAssignment.getCreatedDate()

        );
    }

    @Override
    public InstructorAssignment toEntity(InstructorAssignmentRequest dto) {
        return mapToEntity(new InstructorAssignment(), dto);
    }

    @Override
    public InstructorAssignment toEntity(InstructorAssignment instructorAssignment, InstructorAssignmentRequest dto) {
        return mapToEntity(instructorAssignment, dto);
    }

    private InstructorAssignment mapToEntity(InstructorAssignment instructorAssignment, InstructorAssignmentRequest dto) {
        instructorAssignment.setInstructor(instructorService.getById(dto.instructorId()));
        instructorAssignment.setStartTime(dto.startTime());
        instructorAssignment.setEndTime(dto.endTime());
        instructorAssignment.setStatus(statusService.getById(dto.statusId()));
        return instructorAssignment;
    }
}
