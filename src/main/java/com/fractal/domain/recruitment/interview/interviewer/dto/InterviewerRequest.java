package com.fractal.domain.recruitment.interview.interviewer.dto;

import java.time.LocalDateTime;

public record InterviewerRequest(
        Long employeeId,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        Long statusId
)
{}
