package com.fractal.domain.recruitment.interview.evaluation.session.answer;

import com.fractal.domain.recruitment.interview.evaluation.session.InterviewEvaluationSession;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;

import java.util.List;


public interface InterviewEvaluationSessionAnswerSubmissionService {
    InterviewEvaluationSession create(Long submissionId, InterviewEvaluationSessionAnswerSubmissionRequest dto);
    List<InterviewEvaluationSession> getAllBySubmissionId(Long evaluationId);
    InterviewEvaluationSession getById(Long evaluationId , Long id);
    InterviewEvaluationSession getById(Long id);
    InterviewEvaluationSession update(Long evaluationId, Long id,InterviewEvaluationSessionAnswerSubmissionRequest dto);
    void delete(Long evaluationId, Long id);
    //InterviewEvaluationSessionResponse toDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer);
    //InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section);


}
