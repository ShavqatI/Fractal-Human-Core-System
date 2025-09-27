package com.fractal.domain.interview.interviewee.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;

import java.time.LocalDateTime;

public record IntervieweeResponse(
        Long id,
        CandidateCompactResponse candidate,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
