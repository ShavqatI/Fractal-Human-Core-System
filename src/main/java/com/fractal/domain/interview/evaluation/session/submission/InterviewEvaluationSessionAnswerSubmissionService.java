package com.fractal.domain.interview.evaluation.session.submission;

import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionCompactResponse;
import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionResponse;

import java.util.List;


public interface InterviewEvaluationSessionAnswerSubmissionService {
    InterviewEvaluationSessionAnswerSubmission create(Long evaluationSessionId, InterviewEvaluationSessionAnswerSubmissionRequest dto);
    List<InterviewEvaluationSessionAnswerSubmission> getAllByInterviewEvaluationSessionId(Long evaluationSessionId);
    InterviewEvaluationSessionAnswerSubmission getById(Long evaluationSessionId , Long id);
    InterviewEvaluationSessionAnswerSubmission getById(Long id);
    InterviewEvaluationSessionAnswerSubmission update(Long evaluationSessionId, Long id,InterviewEvaluationSessionAnswerSubmissionRequest dto);
    void delete(Long evaluationId, Long id);
    InterviewEvaluationSessionAnswerSubmission save(InterviewEvaluationSessionAnswerSubmission answerSubmission);
    InterviewEvaluationSessionAnswerSubmissionResponse toDTO(InterviewEvaluationSessionAnswerSubmission answerSubmission);
    InterviewEvaluationSessionAnswerSubmissionCompactResponse toCompactDTO(InterviewEvaluationSessionAnswerSubmission answerSubmission);


}
