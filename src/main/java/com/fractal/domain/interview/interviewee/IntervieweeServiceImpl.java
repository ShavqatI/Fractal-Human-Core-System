package com.fractal.domain.interview.interviewee;

import com.fractal.domain.interview.interviewee.candidate.CandidateIntervieweeService;
import com.fractal.domain.interview.interviewee.candidate.dto.CandidateIntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewee.employee.EmployeeIntervieweeService;
import com.fractal.domain.interview.interviewee.employee.dto.EmployeeIntervieweeRequest;
import com.fractal.domain.interview.interviewee.mapper.IntervieweeMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class IntervieweeServiceImpl implements IntervieweeService {
    private final CandidateIntervieweeService candidateIntervieweeService;
    private final EmployeeIntervieweeService employeeIntervieweeService;
    private final IntervieweeRepository intervieweeRepository;
    private final IntervieweeMapperService mapperService;

    @Override
    public Interviewee create(Long interviewId, IntervieweeRequest dto) {
        Interviewee interviewee = null;
        if (dto instanceof CandidateIntervieweeRequest candidateIntervieweeRequest) {
            interviewee = candidateIntervieweeService.create(interviewId, candidateIntervieweeRequest);
        } else if (dto instanceof EmployeeIntervieweeRequest employeeIntervieweeRequest) {
            interviewee = employeeIntervieweeService.create(interviewId, employeeIntervieweeRequest);
        }
        return interviewee;
    }

    @Override
    public Interviewee update(Long interviewId, Long id, IntervieweeRequest dto) {
        Interviewee interviewee = null;
        if (dto instanceof CandidateIntervieweeRequest candidateIntervieweeRequest) {
            interviewee = candidateIntervieweeService.update(interviewId, id, candidateIntervieweeRequest);
        } else if (dto instanceof EmployeeIntervieweeRequest employeeIntervieweeRequest) {
            interviewee = employeeIntervieweeService.update(interviewId, id, employeeIntervieweeRequest);
        }
        return interviewee;
    }

    @Override
    public List<Interviewee> getAllByInterviewId(Long interviewerId) {
        return null;
    }

    @Override
    public void delete(Long interviewId, Long id) {
        intervieweeRepository.delete(intervieweeRepository.findByInterviewIdAndId(interviewId, id));
    }

    @Override
    public IntervieweeResponse toDTO(Interviewee interviewee) {
        return mapperService.toDTO(interviewee);
    }

    @Override
    public IntervieweeCompactResponse toCompactDTO(Interviewee interviewee) {
        return mapperService.toCompactDTO(interviewee);
    }
}
