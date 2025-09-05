package com.fractal.domain.recruitment.interview.evaluation.session.dto;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.dto.UserResponse;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.recruitment.interview.Interview;
import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerResponse;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationSessionResponse(
        Long id,
        LocalDateTime startDate,
        LocalDateTime endDate,
        List<InterviewEvaluationSessionAnswerSubmissionResponse> submissions,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
