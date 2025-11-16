package com.fractal.domain.interview.evaluation.session.submission.selected_answer;

import com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto.InterviewEvaluationSessionSelectedAnswerCompactResponse;
import com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto.InterviewEvaluationSessionSelectedAnswerRequest;
import com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto.InterviewEvaluationSessionSelectedAnswerResponse;

import java.util.List;


public interface InterviewEvaluationSessionSelectedAnswerService {
    InterviewEvaluationSessionSelectedAnswer create(Long answerSubmissionId, InterviewEvaluationSessionSelectedAnswerRequest dto);

    List<InterviewEvaluationSessionSelectedAnswer> getAllByInterviewEvaluationSessionAnswerSubmissionId(Long answerSubmissionId);

    InterviewEvaluationSessionSelectedAnswer getById(Long answerSubmissionId, Long id);

    InterviewEvaluationSessionSelectedAnswer update(Long answerSubmissionId, Long id, InterviewEvaluationSessionSelectedAnswerRequest dto);

    void delete(Long answerSubmissionId, Long id);

    InterviewEvaluationSessionSelectedAnswerResponse toDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer);

    InterviewEvaluationSessionSelectedAnswerCompactResponse toCompactDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer);


}
