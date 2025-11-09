package com.fractal.domain.interview.evaluation.session.submission;

import com.fractal.domain.interview.evaluation.session.InterviewEvaluationSessionService;
import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionCompactResponse;
import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionResponse;
import com.fractal.domain.interview.evaluation.session.submission.mapper.InterviewEvaluationSessionAnswerSubmissionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSessionAnswerSubmissionServiceImpl implements InterviewEvaluationSessionAnswerSubmissionService {

    private final InterviewEvaluationSessionAnswerSubmissionRepository submissionRepository;
    private final InterviewEvaluationSessionAnswerSubmissionMapperService mapperService;
    private final InterviewEvaluationSessionService evaluationSessionService;


    @Override
    @Transactional
    public InterviewEvaluationSessionAnswerSubmission create(Long evaluationSessionId, InterviewEvaluationSessionAnswerSubmissionRequest dto) {
        var evaluationSession = evaluationSessionService.getById(evaluationSessionId);
        var answerSubmission = mapperService.toEntity(dto);
        evaluationSession.addSubmission(answerSubmission);
        evaluationSessionService.save(evaluationSession);
       return answerSubmission;
    }

    @Override
    public List<InterviewEvaluationSessionAnswerSubmission> getAllByInterviewEvaluationSessionId(Long evaluationSessionId) {
        return submissionRepository.findAllByInterviewEvaluationSessionId(evaluationSessionId);
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmission getById(Long evaluationSessionId, Long id) {
        return submissionRepository.findByInterviewEvaluationSessionIdAndId(evaluationSessionId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Session Answer Submission with id: " + id + " not found"));
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmission getById(Long id) {
        return submissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Session Answer Submission with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InterviewEvaluationSessionAnswerSubmission update(Long evaluationId, Long id, InterviewEvaluationSessionAnswerSubmissionRequest dto) {
        var evaluationSession = evaluationSessionService.getById(evaluationId);
        var answerSubmission = evaluationSession.getSubmissions()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Session Answer Submission with id: " + id + " not found"));
        answerSubmission = submissionRepository.save(mapperService.toEntity(answerSubmission,dto));
        evaluationSessionService.save(evaluationSession);
        return answerSubmission;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var evaluationSession = evaluationSessionService.getById(employeeId);
        var answerSubmission = evaluationSession.getSubmissions()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Session Answer Submission with id: " + id + " not found"));
        evaluationSession.removeSubmission(answerSubmission);
        evaluationSessionService.save(evaluationSession);
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmissionResponse toDTO(InterviewEvaluationSessionAnswerSubmission submission) {
        return mapperService.toDTO(submission);
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmissionCompactResponse toCompactDTO(InterviewEvaluationSessionAnswerSubmission answerSubmission) {
        return mapperService.toCompactDTO(answerSubmission);
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmission save(InterviewEvaluationSessionAnswerSubmission answerSubmission) {
        try {
            return submissionRepository.save(answerSubmission);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
