package com.fractal.domain.interview.evaluation.session;

import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionRequest;
import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionResponse;
import com.fractal.domain.interview.evaluation.session.mapper.InterviewEvaluationSessionMapperService;
import com.fractal.domain.interview.interviewer.InterviewerService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSessionServiceImpl implements InterviewEvaluationSessionService {

    private final InterviewEvaluationSessionRepository evaluationSessionRepository;
    private final InterviewEvaluationSessionMapperService mapperService;
    private final InterviewerService interviewerService;


    @Override
    public InterviewEvaluationSession create(Long interviewerId, InterviewEvaluationSessionRequest dto) {
        var interviewer = interviewerService.getById(interviewerId);
        var evaluationSession = mapperService.toEntity(dto);
        interviewer.addEvaluationSession(evaluationSession);
        interviewerService.save(interviewer);
        return evaluationSession;
    }

    @Override
    public List<InterviewEvaluationSession> getAllByInterviewerId(Long interviewerId) {
        return evaluationSessionRepository.findAllByInterviewerId(interviewerId);
    }

    @Override
    public InterviewEvaluationSession getById(Long interviewerId, Long id) {
        return evaluationSessionRepository.findByInterviewerIdAndId(interviewerId, id).orElseThrow(() -> new ResourceNotFoundException("Interview Evaluation Session with id: " + id + " not found"));
    }

    @Override
    public InterviewEvaluationSession getById(Long id) {
        return evaluationSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Interview Evaluation Session with id: " + id + " not found"));
    }

    @Override
    public InterviewEvaluationSession update(Long interviewerId, Long id, InterviewEvaluationSessionRequest dto) {
        var interviewer = interviewerService.getById(interviewerId);
        var evaluationSession = interviewer.getEvaluationSessions()
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Interview Evaluation Session id: " + id + " not found"));
        evaluationSession = evaluationSessionRepository.save(mapperService.toEntity(evaluationSession, dto));
        interviewerService.save(interviewer);
        return evaluationSession;
    }

    @Override
    public void delete(Long interviewerId, Long id) {
        var interviewer = interviewerService.getById(interviewerId);
        var evaluationSession = interviewer.getEvaluationSessions()
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Interview Evaluation Session id: " + id + " not found"));
        interviewer.removeEvaluationSession(evaluationSession);
        interviewerService.save(interviewer);
    }


    @Override
    public InterviewEvaluationSession save(InterviewEvaluationSession session) {
        try {
            return evaluationSessionRepository.save(session);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public InterviewEvaluationSessionResponse toDTO(InterviewEvaluationSession evaluationSession) {
        return mapperService.toDTO(evaluationSession);
    }
}
