package com.fractal.domain.recruitment.candidate.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.address.mapper.CandidateAddressMapperService;
import com.fractal.domain.recruitment.candidate.citizenship.mapper.CandidateCitizenshipMapperService;
import com.fractal.domain.recruitment.candidate.contact.mapper.CandidateContactMapperService;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import com.fractal.domain.recruitment.candidate.education.mapper.CandidateEducationMapperService;
import com.fractal.domain.recruitment.candidate.employment.mapper.CandidateEmploymentMapperService;
import com.fractal.domain.recruitment.candidate.identification_document.mapper.CandidateIdentificationDocumentMapperService;
import com.fractal.domain.recruitment.candidate.language_skill.mapper.CandidateLanguageSkillMapperService;
import com.fractal.domain.recruitment.candidate.military_service.mapper.CandidateMilitaryServiceMapperService;
import com.fractal.domain.recruitment.candidate.professional_experience.mapper.CandidateProfessionalExperienceMapperService;
import com.fractal.domain.recruitment.candidate.resource.mapper.CandidateResourceMapperService;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileRequest;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class CandidateMapperServiceImpl implements CandidateMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final CandidateIdentificationDocumentMapperService identificationDocumentMapperService;
    private final CandidateCitizenshipMapperService citizenshipMapperService;
    private final CandidateAddressMapperService addressMapperService;
    private final CandidateContactMapperService contactMapperService;
    private final CandidateEducationMapperService educationMapperService;
    private final CandidateLanguageSkillMapperService languageSkillMapperService;
    private final CandidateEmploymentMapperService employmentMapperService;
    private final CandidateProfessionalExperienceMapperService professionalExperienceMapperService;
    private final CandidateResourceMapperService resourceMapperService;
    private final CandidateMilitaryServiceMapperService militaryServiceMapperService;


    @Override
    public CandidateResponse toDTO(Candidate candidate) {
        return new CandidateResponse(
                candidate.getId(),
                candidate.getLastName(),
                candidate.getFirstName(),
                candidate.getPatronymicName(),
                candidate.getBirthDate(),
                candidate.getTin(),
                candidate.getSsn(),
                genderService.toDTO(candidate.getGender()),
                maritalStatusService.toDTO(candidate.getMaritalStatus()),
                nationalityService.toDTO(candidate.getNationality()),
                Optional.ofNullable(candidate.getIdentificationDocuments())
                        .orElse(emptyList())
                        .stream()
                        .map(identificationDocumentMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getCitizenships())
                        .orElse(emptyList())
                        .stream()
                        .map(citizenshipMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getEducations())
                        .orElse(emptyList())
                        .stream()
                        .map(educationMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getLanguageSkills())
                        .orElse(emptyList())
                        .stream()
                        .map(languageSkillMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getEmployments())
                        .orElse(emptyList())
                        .stream()
                        .map(employmentMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getProfessionalExperiences())
                        .orElse(emptyList())
                        .stream()
                        .map(professionalExperienceMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getMilitaryServices())
                        .orElse(emptyList())
                        .stream()
                        .map(militaryServiceMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(candidate.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(candidate.getStatus()),
                candidate.getCreatedDate()

        );
    }

    @Override
    public CandidateCompactResponse toCompactDTO(Candidate candidate) {
        return new CandidateCompactResponse(
                candidate.getId(),
                candidate.getLastName(),
                candidate.getFirstName(),
                candidate.getPatronymicName(),
                candidate.getBirthDate(),
                candidate.getTin(),
                candidate.getSsn(),
                candidate.getGender().getName(),
                candidate.getMaritalStatus().getName(),
                candidate.getNationality().getName()
        );
    }

    @Override
    public CandidateProfileResponse toAccountDTO(Candidate candidate) {
        return new CandidateProfileResponse(
                candidate.getId(),
                candidate.getLastName(),
                candidate.getFirstName(),
                candidate.getPatronymicName(),
                candidate.getBirthDate(),
                genderService.toDTO(candidate.getGender()),
                Optional.ofNullable(candidate.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(candidate.getStatus()),
                candidate.getCreatedDate()

        );
    }

    @Override
    public Candidate toEntity(CandidateRequest dto) {
        return mapToEntity(new Candidate(), dto);
    }

    @Override
    public Candidate toEntity(CandidateProfileRequest dto) {
        var candidate = Candidate.builder()
                .lastName(dto.lastName())
                .firstName(dto.firstName())
                .patronymicName(dto.patronymicName())
                .birthDate(dto.birthDate())
                .gender(genderService.getById(dto.genderId()))
                .status(statusService.getByCode("ACTIVE"))
                .build();
        dto.contacts().forEach(contact->candidate.addContact(contactMapperService.toEntity(contact)));
        return candidate;
    }

    @Override
    public Candidate toEntity(Candidate candidate, CandidateRequest dto) {
        return mapToEntity(candidate, dto);
    }

    private Candidate mapToEntity(Candidate candidate, CandidateRequest dto) {
        candidate.setLastName(dto.lastName());
        candidate.setFirstName(dto.firstName());
        candidate.setPatronymicName(dto.patronymicName());
        candidate.setBirthDate(dto.birthDate());
        candidate.setTin(dto.tin());
        candidate.setSsn(dto.ssn());
        candidate.setGender(genderService.getById(dto.genderId()));
        candidate.setMaritalStatus(maritalStatusService.getById(dto.maritalStatusId()));
        candidate.setNationality(nationalityService.getById(dto.nationalityId()));
        candidate.setStatus(statusService.getById(dto.statusId()));

        dto.identificationDocuments().forEach(identificationDocument->candidate.addIdentificationDocument(identificationDocumentMapperService.toEntity(identificationDocument)));
        dto.citizenships().forEach(citizenship-> candidate.addCitizenship(citizenshipMapperService.toEntity(citizenship)));
        dto.addresses().forEach(address->candidate.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact->candidate.addContact(contactMapperService.toEntity(contact)));
        dto.educations().forEach(education->candidate.addEducation(educationMapperService.toEntity(education)));
        dto.languageSkills().forEach(languageSkill -> candidate.addLanguageSkill(languageSkillMapperService.toEntity(languageSkill)));
        dto.employments().forEach(employment->candidate.addEmployment(employmentMapperService.toEntity(employment)));
        dto.professionalExperiences().forEach(professionalExperience-> candidate.addProfessionalExperience(professionalExperienceMapperService.toEntity(professionalExperience)));
        dto.militaryServices().forEach(militaryService->candidate.addMilitaryService(militaryServiceMapperService.toEntity(militaryService)));
        dto.resources().forEach(file-> candidate.addResource(resourceMapperService.toEntity(file,null)));
        return candidate;
    }
}
