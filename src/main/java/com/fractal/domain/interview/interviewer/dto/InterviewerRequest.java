package com.fractal.domain.interview.interviewer.dto;

import java.time.LocalDateTime;

public record InterviewerRequest(
        Long employeeId,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        Long statusId
)
{}
