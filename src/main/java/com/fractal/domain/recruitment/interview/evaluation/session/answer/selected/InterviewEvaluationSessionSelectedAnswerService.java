package com.fractal.domain.recruitment.interview.evaluation.session.answer.selected;

import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;

import java.util.List;


public interface InterviewEvaluationSessionSelectedAnswerService {
    InterviewEvaluationSessionSelectedAnswer create(Long answerSubmissionId, InterviewEvaluationSessionSelectedAnswerRequest dto);
    List<InterviewEvaluationSessionSelectedAnswer> getAllByInterviewEvaluationSessionAnswerSubmissionId(Long answerSubmissionId);
    InterviewEvaluationSessionSelectedAnswer getById(Long answerSubmissionId , Long id);
    InterviewEvaluationSessionSelectedAnswer getById(Long id);
    InterviewEvaluationSessionSelectedAnswer update(Long answerSubmissionId, Long id,InterviewEvaluationSessionSelectedAnswerRequest dto);
    void delete(Long answerSubmissionId, Long id);
    InterviewEvaluationSectionResponse toDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer);
    //InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section);


}
