package com.fractal.domain.training_management.trainer.external.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.training_management.trainer.Trainer;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;
import com.fractal.domain.training_management.trainer.external.ExternalTrainer;
import com.fractal.domain.training_management.trainer.external.contact.mapper.ExternalTrainerContactMapperService;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerCompactResponse;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerRequest;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerResponse;
import com.fractal.domain.training_management.trainer.internal.InternalTrainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class ExternalTrainerMapperServiceImpl implements ExternalTrainerMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final ExternalTrainerContactMapperService contactMapperService;
    @Override
    public ExternalTrainerResponse toDTO(ExternalTrainer trainer) {
        return new ExternalTrainerResponse(
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
    public ExternalTrainerCompactResponse toCompactDTO(ExternalTrainer trainer) {
        return new ExternalTrainerCompactResponse(
                trainer.getId(),
                trainer.getLastName(),
                trainer.getFirstName(),
                trainer.getPatronymicName()
        );
    }

    @Override
    public TrainerCompactResponse toCompactDTO(Trainer trainer) {
        var externalTrainer = (ExternalTrainer) trainer;
        return new TrainerCompactResponse(
                externalTrainer.getId(),
                externalTrainer.getLastName(),
                externalTrainer.getFirstName(),
                externalTrainer.getPatronymicName()
        );
    }

    @Override
    public ExternalTrainer toEntity(ExternalTrainerRequest dto) {
        return mapToEntity(new ExternalTrainer(), dto);
    }

    @Override
    public ExternalTrainer toEntity(ExternalTrainer trainer, ExternalTrainerRequest dto) {
        return mapToEntity(trainer, dto);
    }

    private ExternalTrainer mapToEntity(ExternalTrainer trainer, ExternalTrainerRequest dto) {
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
