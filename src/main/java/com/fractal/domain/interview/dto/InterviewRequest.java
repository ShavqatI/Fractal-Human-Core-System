package com.fractal.domain.interview.dto;

import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewer.dto.InterviewerRequest;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewRequest(
        Long interviewTypeId,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        String description,
        String notes,
        String details,
        List<InterviewerRequest> interviewers,
        List<IntervieweeRequest> interviewees,
        List<InterviewEvaluationSessionRequest> evaluationSessions,
        Long statusId
) {
}