package com.fractal.domain.interview.template.section.question.answer;

import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerRequest;
import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerResponse;

import java.util.List;


public interface InterviewTemplateAnswerService {
    InterviewTemplateAnswer create(Long questionId, InterviewTemplateAnswerRequest dto);
    List<InterviewTemplateAnswer> getAllByQuestionId(Long questionId);
    InterviewTemplateAnswer getById(Long questionId , Long id);
    InterviewTemplateAnswer update(Long questionId, Long id, InterviewTemplateAnswerRequest dto);
    void delete(Long questionId, Long id);
    InterviewTemplateAnswerResponse toDTO(InterviewTemplateAnswer answer);

}
