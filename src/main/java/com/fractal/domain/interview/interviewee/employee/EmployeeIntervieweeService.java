package com.fractal.domain.interview.interviewee.employee;


import com.fractal.domain.interview.interviewee.IntervieweeService;
import com.fractal.domain.interview.interviewee.employee.dto.EmployeeIntervieweeRequest;

public interface EmployeeIntervieweeService extends IntervieweeService {
    EmployeeInterviewee create(Long interviewId, EmployeeIntervieweeRequest dto);
    EmployeeInterviewee update(Long interviewId, Long id, EmployeeIntervieweeRequest dto);
}
