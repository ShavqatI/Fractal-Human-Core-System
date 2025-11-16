package com.fractal.domain.interview.interviewee.employee.dto;

import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;

import java.time.LocalDateTime;

public record EmployeeIntervieweeRequest(
        Long employeeId,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        Long statusId
) implements IntervieweeRequest {
}
