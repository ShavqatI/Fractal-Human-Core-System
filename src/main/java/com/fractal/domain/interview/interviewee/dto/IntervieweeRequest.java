package com.fractal.domain.interview.interviewee.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fractal.domain.interview.interviewee.candidate.dto.CandidateIntervieweeRequest;
import com.fractal.domain.interview.interviewee.employee.dto.EmployeeIntervieweeRequest;

import java.time.LocalDateTime;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,       // Use a type name in JSON
        property = "intervieweeKind",      // JSON must include this field
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CandidateIntervieweeRequest.class, name = "CANDIDATE"),
        @JsonSubTypes.Type(value = EmployeeIntervieweeRequest.class, name = "EMPLOYEE")
})
public interface IntervieweeRequest {
    LocalDateTime scheduledTime();

    Integer durationMinutes();

    Long statusId();
}