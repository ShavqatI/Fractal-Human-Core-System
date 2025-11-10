package com.fractal.domain.interview.interviewee.employee;

import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewee.employee.dto.EmployeeIntervieweeRequest;

import java.util.List;

public interface EmployeeIntervieweeService {
    EmployeeInterviewee create(Long interviewId, EmployeeIntervieweeRequest dto);
    EmployeeInterviewee update(Long interviewId, Long id, EmployeeIntervieweeRequest dto);
    List<EmployeeInterviewee> getAllByInterviewId(Long interviewerId);
    Interviewee getById(Long interviewId , Long id);
    void delete(Long interviewId, Long id);
    IntervieweeResponse toDTO(EmployeeInterviewee interviewee);
    IntervieweeCompactResponse toCompactDTO(EmployeeInterviewee interviewee);
}
