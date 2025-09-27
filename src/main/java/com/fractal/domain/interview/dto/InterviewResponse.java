package com.fractal.domain.interview.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewer.dto.InterviewerResponse;
import com.fractal.domain.interview.type.dto.InterviewTypeResponse;

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
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
