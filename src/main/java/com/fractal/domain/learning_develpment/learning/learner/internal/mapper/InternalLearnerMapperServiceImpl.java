package com.fractal.domain.learning_develpment.learning.learner.internal.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.learning_develpment.learning.learner.internal.InternalLearner;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InternalLearnerMapperServiceImpl implements InternalLearnerMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final EmployeeContactMapperService contactMapperService;
    private final EmployeeService employeeService;
    @Override
    public InternalLearnerResponse toDTO(InternalLearner learner) {
        return new InternalLearnerResponse(
                learner.getId(),
                learner.getEmployee().getLastName(),
                learner.getEmployee().getFirstName(),
                learner.getEmployee().getPatronymicName(),
                learner.getEmployee().getBirthDate(),
                learner.getEmployee().getTin(),
                learner.getEmployee().getSsn(),
                genderService.toDTO(learner.getEmployee().getGender()),
                maritalStatusService.toDTO(learner.getEmployee().getMaritalStatus()),
                nationalityService.toDTO(learner.getEmployee().getNationality()),
                Optional.ofNullable(learner.getEmployee().getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(learner.getStatus()),
                learner.getCreatedDate()

        );
    }

    @Override
    public InternalLearnerCompactResponse toCompactDTO(InternalLearner learner) {
        return new InternalLearnerCompactResponse(
                learner.getId(),
                learner.getEmployee().getLastName(),
                learner.getEmployee().getFirstName(),
                learner.getEmployee().getPatronymicName()
        );
    }

    @Override
    public InternalLearner toEntity(InternalLearnerRequest dto) {
        return mapToEntity(new InternalLearner(), dto);
    }

    @Override
    public InternalLearner toEntity(InternalLearner trainer, InternalLearnerRequest dto) {
        return mapToEntity(trainer, dto);
    }

    private InternalLearner mapToEntity(InternalLearner trainer, InternalLearnerRequest dto) {
        trainer.setEmployee(employeeService.getById(dto.employeeId()));
        trainer.setStatus(statusService.getById(dto.statusId()));
        return trainer;
    }
}
