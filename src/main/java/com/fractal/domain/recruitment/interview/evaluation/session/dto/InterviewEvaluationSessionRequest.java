package com.fractal.domain.recruitment.interview.evaluation.session.dto;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.recruitment.interview.Interview;
import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.InterviewEvaluationSessionAnswerSubmission;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record InterviewEvaluationSessionRequest(
        LocalDateTime startDate,
        LocalDateTime endDate,
        List<InterviewEvaluationSessionAnswerSubmissionRequest> submissions,
        Long statusId
) {}