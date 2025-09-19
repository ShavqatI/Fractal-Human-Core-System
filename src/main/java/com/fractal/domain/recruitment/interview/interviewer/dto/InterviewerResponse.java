package com.fractal.domain.recruitment.interview.interviewer.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;

import java.time.LocalDateTime;

public record InterviewerResponse(
        Long id,
        EmployeeCompactResponse employee,
        LocalDateTime scheduledTime,
        Integer durationMinutes,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
