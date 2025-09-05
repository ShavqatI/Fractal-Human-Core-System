package com.fractal.domain.recruitment.interview.evaluation.session;

import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.InterviewEvaluationSessionAnswerSubmission;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.InterviewEvaluationSessionSelectedAnswer;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;

import java.util.List;


public interface InterviewEvaluationSessionService {
    InterviewEvaluationSession create(Long interviewId, InterviewEvaluationSessionSelectedAnswerRequest dto);
    List<InterviewEvaluationSession> getAllByInterviewId(Long interviewId);
    InterviewEvaluationSession getById(Long interviewId , Long id);
    InterviewEvaluationSession getById(Long id);
    InterviewEvaluationSession update(Long interviewId, Long id,InterviewEvaluationSessionSelectedAnswerRequest dto);
    void delete(Long interviewId, Long id);
    InterviewEvaluationSession save(InterviewEvaluationSession session);
    //InterviewEvaluationSessionResponse toDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer);
    //InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section);


}
