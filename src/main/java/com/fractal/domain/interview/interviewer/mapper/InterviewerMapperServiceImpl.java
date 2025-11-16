package com.fractal.domain.interview.interviewer.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.interview.interviewer.Interviewer;
import com.fractal.domain.interview.interviewer.dto.InterviewerRequest;
import com.fractal.domain.interview.interviewer.dto.InterviewerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InterviewerMapperServiceImpl implements InterviewerMapperService {

    private final EmployeeService employeeService;
    private final StatusService statusService;

    @Override
    public InterviewerResponse toDTO(Interviewer interviewer) {
        return null;
    }

    @Override
    public Interviewer toEntity(InterviewerRequest dto) {
        return mapToEntity(new Interviewer(), dto);
    }

    @Override
    public Interviewer toEntity(Interviewer interviewer, InterviewerRequest dto) {
        return mapToEntity(interviewer, dto);
    }

    private Interviewer mapToEntity(Interviewer interviewer, InterviewerRequest dto) {
        interviewer.setEmployee(employeeService.getById(dto.employeeId()));
        interviewer.setScheduledTime(dto.scheduledTime());
        interviewer.setDurationMinutes(dto.durationMinutes());
        interviewer.setStatus(statusService.getById(dto.statusId()));
        return interviewer;

    }
}
