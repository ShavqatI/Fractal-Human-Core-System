package com.fractal.domain.interview.interviewee.candidate.dto;

import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;

import java.time.LocalDateTime;

public record CandidateIntervieweeRequest(
        Long candidateId,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        Long statusId
) implements IntervieweeRequest {
}
