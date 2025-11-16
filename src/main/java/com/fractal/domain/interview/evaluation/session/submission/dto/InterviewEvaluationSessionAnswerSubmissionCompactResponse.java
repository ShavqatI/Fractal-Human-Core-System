package com.fractal.domain.interview.evaluation.session.submission.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;
import com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto.InterviewEvaluationSessionSelectedAnswerResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationSessionAnswerSubmissionCompactResponse(
        Long id,
        InterviewEvaluationQuestionResponse question,
        List<InterviewEvaluationSessionSelectedAnswerResponse> answers,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
