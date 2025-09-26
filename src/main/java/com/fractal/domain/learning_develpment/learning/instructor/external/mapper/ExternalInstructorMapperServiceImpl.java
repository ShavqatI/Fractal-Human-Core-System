package com.fractal.domain.learning_develpment.learning.instructor.external.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.learning_develpment.learning.instructor.Instructor;
import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.ExternalInstructor;
import com.fractal.domain.learning_develpment.learning.instructor.external.contact.mapper.ExternalInstructorContactMapperService;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class ExternalInstructorMapperServiceImpl implements ExternalInstructorMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final ExternalInstructorContactMapperService contactMapperService;
    @Override
    public ExternalInstructorResponse toDTO(ExternalInstructor instructor) {
        return new ExternalInstructorResponse(
                instructor.getId(),
                instructor.getLastName(),
                instructor.getFirstName(),
                instructor.getPatronymicName(),
                instructor.getBirthDate(),
                instructor.getTin(),
                instructor.getSsn(),
                genderService.toDTO(instructor.getGender()),
                maritalStatusService.toDTO(instructor.getMaritalStatus()),
                nationalityService.toDTO(instructor.getNationality()),
                Optional.ofNullable(instructor.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(instructor.getStatus()),
                instructor.getCreatedDate()

        );
    }

    @Override
    public ExternalInstructorCompactResponse toCompactDTO(ExternalInstructor instructor) {
        return new ExternalInstructorCompactResponse(
                instructor.getId(),
                instructor.getLastName(),
                instructor.getFirstName(),
                instructor.getPatronymicName()
        );
    }

    @Override
    public InstructorCompactResponse toCompactDTO(Instructor instructor) {
        var externalTrainer = (ExternalInstructor) instructor;
        return new InstructorCompactResponse(
                externalTrainer.getId(),
                externalTrainer.getLastName(),
                externalTrainer.getFirstName(),
                externalTrainer.getPatronymicName()
        );
    }

    @Override
    public ExternalInstructor toEntity(ExternalInstructorRequest dto) {
        return mapToEntity(new ExternalInstructor(), dto);
    }

    @Override
    public ExternalInstructor toEntity(ExternalInstructor instructor, ExternalInstructorRequest dto) {
        return mapToEntity(instructor, dto);
    }

    private ExternalInstructor mapToEntity(ExternalInstructor trainer, ExternalInstructorRequest dto) {
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
