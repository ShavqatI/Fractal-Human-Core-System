package com.fractal.domain.interview.interviewee.mapper;

import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.candidate.CandidateInterviewee;
import com.fractal.domain.interview.interviewee.candidate.dto.CandidateIntervieweeRequest;
import com.fractal.domain.interview.interviewee.candidate.mapper.CandidateIntervieweeMapperService;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewee.employee.EmployeeInterviewee;
import com.fractal.domain.interview.interviewee.employee.dto.EmployeeIntervieweeRequest;
import com.fractal.domain.interview.interviewee.employee.mapper.EmployeeIntervieweeMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class IntervieweeMapperServiceImpl implements IntervieweeMapperService {

    private final CandidateIntervieweeMapperService candidateIntervieweeMapperService;
    private final EmployeeIntervieweeMapperService employeeIntervieweeMapperService;
    @Override
    public IntervieweeResponse toDTO(Interviewee interviewee) {
        if (interviewee instanceof CandidateInterviewee candidateInterviewee) {
            candidateIntervieweeMapperService.toDTO(candidateInterviewee);
        } else if (interviewee instanceof EmployeeInterviewee employeeInterviewee) {
            employeeIntervieweeMapperService.toDTO(employeeInterviewee);
        }
        return null;
    }

    @Override
    public Interviewee toEntity(IntervieweeRequest dto) {
        if(dto instanceof CandidateIntervieweeRequest candidateIntervieweeRequest) {
            return candidateIntervieweeMapperService.toEntity(candidateIntervieweeRequest);
        } else if (dto instanceof EmployeeIntervieweeRequest employeeIntervieweeRequest) {
            return employeeIntervieweeMapperService.toEntity(employeeIntervieweeRequest);
        }
        return null;
    }
}
