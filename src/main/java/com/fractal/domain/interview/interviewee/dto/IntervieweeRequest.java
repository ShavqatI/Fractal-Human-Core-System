package com.fractal.domain.interview.interviewee.dto;

import java.time.LocalDateTime;

public record IntervieweeRequest(
        Long candidateId,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        Long statusId
)
{}