package com.fractal.domain.recruitment.interview.evaluation.session;

import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.InterviewEvaluationSessionSelectedAnswer;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;

import java.util.List;


public interface InterviewEvaluationSessionService {
    InterviewEvaluationSession create(Long submissionId, InterviewEvaluationSessionSelectedAnswerRequest dto);
    List<InterviewEvaluationSession> getAllBySubmissionId(Long evaluationId);
    InterviewEvaluationSession getById(Long evaluationId , Long id);
    InterviewEvaluationSession getById(Long id);
    InterviewEvaluationSession update(Long evaluationId, Long id,InterviewEvaluationSessionSelectedAnswerRequest dto);
    void delete(Long evaluationId, Long id);
    //InterviewEvaluationSessionResponse toDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer);
    //InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section);


}
