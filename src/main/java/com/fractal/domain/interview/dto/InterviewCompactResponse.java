package com.fractal.domain.interview.dto;

import com.fractal.domain.interview.type.dto.InterviewTypeResponse;

import java.time.LocalDateTime;

public record InterviewCompactResponse(
        Long id,
        InterviewTypeResponse interviewType,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        String description,
        String notes,
        String details,
        LocalDateTime createdDate
) {
}
