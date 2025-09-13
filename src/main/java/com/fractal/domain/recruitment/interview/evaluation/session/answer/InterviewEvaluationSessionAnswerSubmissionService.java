package com.fractal.domain.recruitment.interview.evaluation.session.answer;

import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionResponse;

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
