package com.fractal.domain.learning_develpment.learning.session.instructor;

import com.fractal.domain.learning_develpment.learning.session.LearningSessionService;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentRequest;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentResponse;
import com.fractal.domain.learning_develpment.learning.session.instructor.mapper.InstructorAssignmentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class InstructorAssignmentServiceImpl implements InstructorAssignmentService {

    private final InstructorAssignmentRepository instructorAssignmentRepository;
    private final InstructorAssignmentMapperService mapperService;
    private final LearningSessionService sessionService;

    @Override
    @Transactional
    public InstructorAssignment create(Long sessionId, InstructorAssignmentRequest dto) {
        var session = sessionService.getById(sessionId);
        var trainerAssignment = mapperService.toEntity(dto);
        session.addInstructorAssignment(trainerAssignment);
        sessionService.save(session);
       return trainerAssignment;
    }

    @Override
    public List<InstructorAssignment> getAllByLearningSessionId(Long sessionId) {
        return instructorAssignmentRepository.findAllByLearningSessionId(sessionId);
    }

    @Override
    public InstructorAssignment getById(Long sessionId, Long id) {
        return instructorAssignmentRepository.findByLearningSessionIdAndId(sessionId,id).orElseThrow(()-> new ResourceNotFoundException("Instructor Assignment  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InstructorAssignment update(Long sessionId, Long id, InstructorAssignmentRequest dto) {
        var session = sessionService.getById(sessionId);
        var instructorAssignment = session.getInstructorAssignments()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Instructor Assignment  with id: " + id + " not found"));
        instructorAssignment = mapperService.toEntity(instructorAssignment,dto);
        instructorAssignmentRepository.save(instructorAssignment);
        sessionService.save(session);
       return instructorAssignment;
    }

    @Override
    @Transactional
    public void delete(Long sessionId, Long id) {
        var session = sessionService.getById(sessionId);
        var instructorAssignment = session.getInstructorAssignments()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Instructor Assignment  with id: " + id + " not found"));
        session.removeInstructorAssignment(instructorAssignment);
        sessionService.save(session);
    }

    @Override
    public InstructorAssignmentResponse toDTO(InstructorAssignment instructorAssignment) {
        return mapperService.toDTO(instructorAssignment);
    }



}
