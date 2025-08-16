package com.fractal.domain.recruitment.candidate.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.resource.mapper.EmployeeResourceMapperService;
import com.fractal.domain.employee_management.employment.mapper.EmploymentHistoryMapperService;
import com.fractal.domain.employee_management.military_service.mapper.MilitaryServiceMapperService;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.address.mapper.CandidateAddressMapperService;
import com.fractal.domain.recruitment.candidate.citizenship.mapper.CandidateCitizenshipMapperService;
import com.fractal.domain.recruitment.candidate.contact.mapper.CandidateContactMapperService;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import com.fractal.domain.recruitment.candidate.education.mapper.CandidateEducationMapperService;
import com.fractal.domain.recruitment.candidate.identification_document.mapper.CandidateIdentificationDocumentMapperService;
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
    private final MilitaryServiceMapperService militaryServiceMapperService;
    private final EmploymentHistoryMapperService employmentHistoryMapperService;

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
                candidate.getGender().getName(),
                candidate.getMaritalStatus().getName(),
                candidate.getNationality().getName(),
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
                /*Optional.ofNullable(candidate.getMilitaryServices())
                        .orElse(emptyList())
                        .stream()
                        .map(militaryServiceMapperService::toDTO)
                        .collect(Collectors.toList()),*/
                /*Optional.ofNullable(candidate.getEmploymentHistories())
                        .orElse(emptyList())
                        .stream()
                        .map(employmentHistoryMapperService::toDTO)
                        .collect(Collectors.toList()),*/
                /*Optional.ofNullable(candidate.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(employeeResourceMapperService::toDTO)
                        .collect(Collectors.toList()),*/
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
    public Candidate toEntity(CandidateRequest dto) {
        return mapToEntity(new Candidate(), dto);
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

        dto.identificationDocuments().forEach(identificationDocument->candidate.addIdentificationDocument(identificationDocumentMapperService.toEntity(identificationDocument)));
        dto.citizenships().forEach(citizenship-> candidate.addCitizenship(citizenshipMapperService.toEntity(citizenship)));
        dto.addresses().forEach(address->candidate.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact->candidate.addContact(contactMapperService.toEntity(contact)));
        dto.educations().forEach(education->candidate.addEducation(educationMapperService.toEntity(education)));
        //dto.militaryServices().forEach(militaryService->employee.addMilitaryService(militaryServiceMapperService.toEntity(militaryService)));
        //dto.employmentHistories().forEach(employmentHistory->employee.addEmploymentHistory(employmentHistoryMapperService.toEntity(employmentHistory)));
        //dto.files().forEach(file-> employee.addResource(employeeResourceMapperService.toEntity(file,null)));
        return candidate;
    }
}
