package com.fractal.domain.interview.interviewee.dto;

public record IntervieweeCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {

}
