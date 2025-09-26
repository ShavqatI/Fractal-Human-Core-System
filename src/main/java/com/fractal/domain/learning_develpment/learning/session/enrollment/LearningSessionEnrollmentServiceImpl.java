package com.fractal.domain.learning_develpment.learning.session.enrollment;

import com.fractal.domain.learning_develpment.learning.session.LearningSessionService;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentRequest;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentResponse;
import com.fractal.domain.learning_develpment.learning.session.enrollment.mapper.LearningSessionEnrollmentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class LearningSessionEnrollmentServiceImpl implements LearningSessionEnrollmentService {

    private final LearningSessionEnrollmentRepository learningSessionEnrollmentRepository;
    private final LearningSessionEnrollmentMapperService mapperService;
    private final LearningSessionService sessionService;

    @Override
    @Transactional
    public LearningSessionEnrollment create(Long sessionId, LearningSessionEnrollmentRequest dto) {
        var session = sessionService.getById(sessionId);
        var enrollment = mapperService.toEntity(dto);
        session.addEnrollment(enrollment);
        sessionService.save(session);
       return enrollment;
    }

    @Override
    public List<LearningSessionEnrollment> getAllByLearningSessionId(Long sessionId) {
        return learningSessionEnrollmentRepository.findAllByLearningSessionId(sessionId);
    }

    @Override
    public LearningSessionEnrollment getById(Long sessionId, Long id) {
        return learningSessionEnrollmentRepository.findByLearningSessionIdAndId(sessionId,id).orElseThrow(()-> new ResourceNotFoundException("Learning Session Enrollment with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public LearningSessionEnrollment update(Long sessionId, Long id, LearningSessionEnrollmentRequest dto) {
        var session = sessionService.getById(sessionId);
        var enrollment = session.getEnrollments()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Learning Session Enrollment with id: " + id + " not found"));
        enrollment = mapperService.toEntity(enrollment,dto);
        learningSessionEnrollmentRepository.save(enrollment);
        sessionService.save(session);
       return enrollment;
    }

    @Override
    @Transactional
    public void delete(Long sessionId, Long id) {
        var session = sessionService.getById(sessionId);
        var trainingParticipation = session.getEnrollments()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Learning Session Enrollment with id: " + id + " not found"));
        session.removeEnrollment(trainingParticipation);
        sessionService.save(session);
    }

    @Override
    public LearningSessionEnrollmentResponse toDTO(LearningSessionEnrollment enrollment) {
        return mapperService.toDTO(enrollment);
    }


}
