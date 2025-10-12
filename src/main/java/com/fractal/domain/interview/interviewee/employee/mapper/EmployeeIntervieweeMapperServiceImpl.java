package com.fractal.domain.interview.interviewee.employee.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewee.employee.EmployeeInterviewee;
import com.fractal.domain.interview.interviewee.employee.dto.EmployeeIntervieweeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
@Primary
class EmployeeIntervieweeMapperServiceImpl implements EmployeeIntervieweeMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final EmployeeContactMapperService contactMapperService;
    private final EmployeeService employeeService;

    @Override
    public IntervieweeResponse toDTO(Interviewee interviewee) {
        var employeeInterviewee = (EmployeeInterviewee) interviewee;
        return new IntervieweeResponse(
                employeeInterviewee.getId(),
                employeeInterviewee.getEmployee().getLastName(),
                employeeInterviewee.getEmployee().getFirstName(),
                employeeInterviewee.getEmployee().getPatronymicName(),
                employeeInterviewee.getEmployee().getBirthDate(),
                employeeInterviewee.getEmployee().getTin(),
                employeeInterviewee.getEmployee().getSsn(),
                genderService.toDTO(employeeInterviewee.getEmployee().getGender()),
                maritalStatusService.toDTO(employeeInterviewee.getEmployee().getMaritalStatus()),
                nationalityService.toDTO(employeeInterviewee.getEmployee().getNationality()),
                Optional.ofNullable(employeeInterviewee.getEmployee().getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(employeeInterviewee.getStatus()),
                employeeInterviewee.getCreatedDate()

        );
    }

    @Override
    public Interviewee toEntity(IntervieweeRequest dto) {
        return toEntity((EmployeeIntervieweeRequest) dto);
    }

    @Override
    public IntervieweeCompactResponse toCompactDTO(EmployeeInterviewee interviewee) {
        return new IntervieweeCompactResponse(
                interviewee.getId(),
                interviewee.getEmployee().getLastName(),
                interviewee.getEmployee().getFirstName(),
                interviewee.getEmployee().getPatronymicName()
        );
    }

    @Override
    public EmployeeInterviewee toEntity(EmployeeIntervieweeRequest dto) {
        return mapToEntity(new EmployeeInterviewee(),dto);
    }

    @Override
    public EmployeeInterviewee toEntity(EmployeeInterviewee interviewee, EmployeeIntervieweeRequest dto) {
        return mapToEntity(interviewee,dto);
    }


    private EmployeeInterviewee mapToEntity(EmployeeInterviewee interviewee, EmployeeIntervieweeRequest dto) {
        interviewee.setEmployee(employeeService.getById(dto.employeeId()));
        interviewee.setScheduledTime(dto.scheduledTime());
        interviewee.setDurationMinutes(dto.durationMinutes());
        interviewee.setStatus(statusService.getById(dto.statusId()));
        return interviewee;
    }


}
