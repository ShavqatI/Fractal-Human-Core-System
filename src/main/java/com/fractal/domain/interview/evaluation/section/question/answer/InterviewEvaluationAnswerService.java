package com.fractal.domain.interview.evaluation.section.question.answer;

import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerRequest;
import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;

import java.util.List;


public interface InterviewEvaluationAnswerService {
    InterviewEvaluationAnswer create(Long questionId, InterviewEvaluationAnswerRequest dto);

    List<InterviewEvaluationAnswer> getAllByQuestionId(Long questionId);

    InterviewEvaluationAnswer getById(Long questionId, Long id);

    InterviewEvaluationAnswer update(Long questionId, Long id, InterviewEvaluationAnswerRequest dto);

    void delete(Long questionId, Long id);

    InterviewEvaluationAnswerResponse toDTO(InterviewEvaluationAnswer answer);

}
