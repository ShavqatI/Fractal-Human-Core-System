package com.fractal.domain.training_management.trainer.internal.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.training_management.trainer.Trainer;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;
import com.fractal.domain.training_management.trainer.internal.InternalTrainer;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerCompactResponse;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerRequest;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InternalTrainerMapperServiceImpl implements InternalTrainerMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final EmployeeContactMapperService contactMapperService;
    private final EmployeeService employeeService;
    @Override
    public InternalTrainerResponse toDTO(InternalTrainer trainer) {
        return new InternalTrainerResponse(
                trainer.getId(),
                trainer.getEmployee().getLastName(),
                trainer.getEmployee().getFirstName(),
                trainer.getEmployee().getPatronymicName(),
                trainer.getEmployee().getBirthDate(),
                trainer.getEmployee().getTin(),
                trainer.getEmployee().getSsn(),
                genderService.toDTO(trainer.getEmployee().getGender()),
                maritalStatusService.toDTO(trainer.getEmployee().getMaritalStatus()),
                nationalityService.toDTO(trainer.getEmployee().getNationality()),
                Optional.ofNullable(trainer.getEmployee().getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(trainer.getStatus()),
                trainer.getCreatedDate()

        );
    }

    @Override
    public InternalTrainerCompactResponse toCompactDTO(InternalTrainer trainer) {
        return new InternalTrainerCompactResponse(
                trainer.getId(),
                trainer.getEmployee().getLastName(),
                trainer.getEmployee().getFirstName(),
                trainer.getEmployee().getPatronymicName()
        );
    }

    @Override
    public TrainerCompactResponse toCompactDTO(Trainer trainer) {
        var internalTrainer = (InternalTrainer) trainer;
        return new TrainerCompactResponse(
                internalTrainer.getId(),
                internalTrainer.getEmployee().getLastName(),
                internalTrainer.getEmployee().getFirstName(),
                internalTrainer.getEmployee().getPatronymicName()
        );
    }

    @Override
    public InternalTrainer toEntity(InternalTrainerRequest dto) {
        return mapToEntity(new InternalTrainer(), dto);
    }

    @Override
    public InternalTrainer toEntity(InternalTrainer trainer, InternalTrainerRequest dto) {
        return mapToEntity(trainer, dto);
    }

    private InternalTrainer mapToEntity(InternalTrainer trainer, InternalTrainerRequest dto) {
        trainer.setEmployee(employeeService.getById(dto.employeeId()));
        trainer.setStatus(statusService.getById(dto.statusId()));
        return trainer;
    }
}
