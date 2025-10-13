package com.fractal.domain.learning_develpment.learning.learner.external.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.learning_develpment.learning.learner.external.ExternalLearner;
import com.fractal.domain.learning_develpment.learning.learner.external.contact.mapper.ExternalParticipantContactMapperService;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class ExternalLearnerMapperServiceImpl implements ExternalLearnerMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final ExternalParticipantContactMapperService contactMapperService;
    @Override
    public ExternalLearnerResponse toDTO(ExternalLearner learner) {
        return new ExternalLearnerResponse(
                learner.getId(),
                learner.getLastName(),
                learner.getFirstName(),
                learner.getPatronymicName(),
                learner.getBirthDate(),
                learner.getTin(),
                learner.getSsn(),
                genderService.toDTO(learner.getGender()),
                maritalStatusService.toDTO(learner.getMaritalStatus()),
                nationalityService.toDTO(learner.getNationality()),
                Optional.ofNullable(learner.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(learner.getStatus()),
                learner.getCreatedDate()

        );
    }

    @Override
    public ExternalLearnerCompactResponse toCompactDTO(ExternalLearner learner) {
        return new ExternalLearnerCompactResponse(
                learner.getId(),
                learner.getLastName(),
                learner.getFirstName(),
                learner.getPatronymicName()
        );
    }

    @Override
    public ExternalLearner toEntity(ExternalLearnerRequest dto) {
        return mapToEntity(new ExternalLearner(), dto);
    }

    @Override
    public ExternalLearner toEntity(ExternalLearner learner, ExternalLearnerRequest dto) {
        return mapToEntity(learner, dto);
    }

    private ExternalLearner mapToEntity(ExternalLearner trainer, ExternalLearnerRequest dto) {
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
