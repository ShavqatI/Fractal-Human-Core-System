package com.fractal.domain.training_management.participant.internal.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.training_management.participant.Participant;
import com.fractal.domain.training_management.participant.dto.ParticipantCompactResponse;
import com.fractal.domain.training_management.participant.internal.InternalParticipant;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantCompactResponse;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantRequest;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InternalParticipantMapperServiceImpl implements InternalParticipantMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final EmployeeContactMapperService contactMapperService;
    private final EmployeeService employeeService;
    @Override
    public InternalParticipantResponse toDTO(InternalParticipant trainer) {
        return new InternalParticipantResponse(
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
    public InternalParticipantCompactResponse toCompactDTO(InternalParticipant trainer) {
        return new InternalParticipantCompactResponse(
                trainer.getId(),
                trainer.getEmployee().getLastName(),
                trainer.getEmployee().getFirstName(),
                trainer.getEmployee().getPatronymicName()
        );
    }

    @Override
    public ParticipantCompactResponse toCompactDTO(Participant participant) {
        var internalParticipant = (InternalParticipant) participant;
        return new ParticipantCompactResponse(
                internalParticipant.getId(),
                internalParticipant.getEmployee().getLastName(),
                internalParticipant.getEmployee().getFirstName(),
                internalParticipant.getEmployee().getPatronymicName()
        );
    }

    @Override
    public InternalParticipant toEntity(InternalParticipantRequest dto) {
        return mapToEntity(new InternalParticipant(), dto);
    }

    @Override
    public InternalParticipant toEntity(InternalParticipant trainer, InternalParticipantRequest dto) {
        return mapToEntity(trainer, dto);
    }

    private InternalParticipant mapToEntity(InternalParticipant trainer, InternalParticipantRequest dto) {
        trainer.setEmployee(employeeService.getById(dto.employeeId()));
        trainer.setStatus(statusService.getById(dto.statusId()));
        return trainer;
    }
}
