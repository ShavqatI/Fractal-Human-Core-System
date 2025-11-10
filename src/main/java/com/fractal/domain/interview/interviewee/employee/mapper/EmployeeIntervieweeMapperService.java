package com.fractal.domain.interview.interviewee.employee.mapper;

import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewee.employee.EmployeeInterviewee;
import com.fractal.domain.interview.interviewee.employee.dto.EmployeeIntervieweeRequest;
import com.fractal.domain.interview.interviewee.mapper.IntervieweeMapperService;

public interface EmployeeIntervieweeMapperService {
    IntervieweeResponse toDTO(EmployeeInterviewee interviewee);
    IntervieweeCompactResponse toCompactDTO(EmployeeInterviewee interviewee);
    EmployeeInterviewee toEntity(EmployeeIntervieweeRequest dto);
    EmployeeInterviewee toEntity(EmployeeInterviewee interviewee, EmployeeIntervieweeRequest dto);
}


