package com.fractal.domain.learning_develpment.learning.instructor.internal.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.learning_develpment.learning.instructor.internal.InternalInstructor;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InternalInstructorMapperServiceImpl implements InternalInstructorMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final EmployeeContactMapperService contactMapperService;
    private final EmployeeService employeeService;
    @Override
    public InternalInstructorResponse toDTO(InternalInstructor instructor) {
        return new InternalInstructorResponse(
                instructor.getId(),
                instructor.getEmployee().getLastName(),
                instructor.getEmployee().getFirstName(),
                instructor.getEmployee().getPatronymicName(),
                instructor.getEmployee().getBirthDate(),
                instructor.getEmployee().getTin(),
                instructor.getEmployee().getSsn(),
                genderService.toDTO(instructor.getEmployee().getGender()),
                maritalStatusService.toDTO(instructor.getEmployee().getMaritalStatus()),
                nationalityService.toDTO(instructor.getEmployee().getNationality()),
                Optional.ofNullable(instructor.getEmployee().getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(instructor.getStatus()),
                instructor.getCreatedDate()

        );
    }

    @Override
    public InternalInstructorCompactResponse toCompactDTO(InternalInstructor instructor) {
        return new InternalInstructorCompactResponse(
                instructor.getId(),
                instructor.getEmployee().getLastName(),
                instructor.getEmployee().getFirstName(),
                instructor.getEmployee().getPatronymicName()
        );
    }

    @Override
    public InternalInstructor toEntity(InternalInstructorRequest dto) {
        return mapToEntity(new InternalInstructor(), dto);
    }

    @Override
    public InternalInstructor toEntity(InternalInstructor instructor, InternalInstructorRequest dto) {
        return mapToEntity(instructor, dto);
    }

    private InternalInstructor mapToEntity(InternalInstructor trainer, InternalInstructorRequest dto) {
        trainer.setEmployee(employeeService.getById(dto.employeeId()));
        trainer.setStatus(statusService.getById(dto.statusId()));
        return trainer;
    }
}
