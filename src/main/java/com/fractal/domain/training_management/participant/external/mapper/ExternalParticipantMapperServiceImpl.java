package com.fractal.domain.training_management.participant.external.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.training_management.participant.Participant;
import com.fractal.domain.training_management.participant.dto.ParticipantCompactResponse;
import com.fractal.domain.training_management.participant.external.ExternalParticipant;
import com.fractal.domain.training_management.participant.external.contact.mapper.ExternalParticipantContactMapperService;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantCompactResponse;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantRequest;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class ExternalParticipantMapperServiceImpl implements ExternalParticipantMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final ExternalParticipantContactMapperService contactMapperService;
    @Override
    public ExternalParticipantResponse toDTO(ExternalParticipant trainer) {
        return new ExternalParticipantResponse(
                trainer.getId(),
                trainer.getLastName(),
                trainer.getFirstName(),
                trainer.getPatronymicName(),
                trainer.getBirthDate(),
                trainer.getTin(),
                trainer.getSsn(),
                genderService.toDTO(trainer.getGender()),
                maritalStatusService.toDTO(trainer.getMaritalStatus()),
                nationalityService.toDTO(trainer.getNationality()),
                Optional.ofNullable(trainer.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(trainer.getStatus()),
                trainer.getCreatedDate()

        );
    }

    @Override
    public ExternalParticipantCompactResponse toCompactDTO(ExternalParticipant trainer) {
        return new ExternalParticipantCompactResponse(
                trainer.getId(),
                trainer.getLastName(),
                trainer.getFirstName(),
                trainer.getPatronymicName()
        );
    }

    @Override
    public ParticipantCompactResponse toCompactDTO(Participant participant) {
        var externalParticipant = (ExternalParticipant) participant;
        return new ParticipantCompactResponse(
                externalParticipant.getId(),
                externalParticipant.getLastName(),
                externalParticipant.getFirstName(),
                externalParticipant.getPatronymicName()
        );
    }

    @Override
    public ExternalParticipant toEntity(ExternalParticipantRequest dto) {
        return mapToEntity(new ExternalParticipant(), dto);
    }

    @Override
    public ExternalParticipant toEntity(ExternalParticipant trainer, ExternalParticipantRequest dto) {
        return mapToEntity(trainer, dto);
    }

    private ExternalParticipant mapToEntity(ExternalParticipant trainer, ExternalParticipantRequest dto) {
        trainer.setLastName(dto.lastName());
        trainer.setFirstName(dto.firstName());
        trainer.setPatronymicName(dto.patronymicName());
        trainer.setBirthDate(dto.birthDate());
        trainer.setTin(dto.tin());
        trainer.setSsn(dto.ssn());
        trainer.setGender(genderService.getById(dto.genderId()));
        trainer.setMaritalStatus(maritalStatusService.getById(dto.maritalStatusId()));
        trainer.setNationality(nationalityService.getById(dto.nationalityId()));
        trainer.setStatus(statusService.getById(dto.statusId()));
        dto.contacts().forEach(contact->trainer.addContact(contactMapperService.toEntity(contact)));
        return trainer;
    }
}
