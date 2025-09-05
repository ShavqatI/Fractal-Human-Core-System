package com.fractal.domain.recruitment.interview.evaluation.session.answer.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationSessionAnswerSubmissionResponse(
        Long id,
        InterviewEvaluationQuestionResponse question,
        List<InterviewEvaluationSessionSelectedAnswerResponse> selectedAnswers,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {}
