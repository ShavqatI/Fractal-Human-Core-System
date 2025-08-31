package com.fractal.domain.recruitment.interview.evaluation.section.question;

import com.fractal.domain.education.Education;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.InterviewEvaluationAnswer;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;

import java.util.List;


public interface InterviewEvaluationQuestionService {
    InterviewEvaluationQuestion create(Long sectionId, InterviewEvaluationQuestionRequest dto);
    List<InterviewEvaluationQuestion> getAllBySectionId(Long sectionId);
    InterviewEvaluationQuestion getById(Long sectionId , Long id);
    InterviewEvaluationQuestion getById(Long id);
    InterviewEvaluationQuestion update(Long sectionId, Long id,InterviewEvaluationQuestionRequest dto);
    void delete(Long sectionId, Long id);
    InterviewEvaluationQuestion save(InterviewEvaluationQuestion question);
    InterviewEvaluationQuestionResponse toDTO(InterviewEvaluationQuestion question);
    InterviewEvaluationQuestionCompactResponse toCompactDTO(InterviewEvaluationQuestion question);

}
