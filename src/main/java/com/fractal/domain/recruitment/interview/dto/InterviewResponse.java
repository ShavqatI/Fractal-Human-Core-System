package com.fractal.domain.recruitment.interview.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.dto.InterviewEvaluationSessionRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.dto.InterviewEvaluationSessionResponse;
import com.fractal.domain.recruitment.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerResponse;
import com.fractal.domain.recruitment.interview.type.dto.InterviewTypeResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewResponse(
        Long id,
        InterviewTypeResponse interviewType,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        String description,
        String notes,
        String details,
        List<InterviewerResponse> interviewers,
        List<IntervieweeResponse> interviewees,
        List<InterviewEvaluationSessionResponse> evaluationSessions,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
