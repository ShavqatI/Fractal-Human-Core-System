package com.fractal.domain.interview.interviewee.dto;

import java.time.LocalDateTime;

public interface IntervieweeRequest {
        LocalDateTime scheduledTime();
        Integer durationMinutes();
        Long statusId();
}