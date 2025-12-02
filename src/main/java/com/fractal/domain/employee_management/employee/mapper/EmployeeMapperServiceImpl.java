package com.fractal.domain.employee_management.employee.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.address.mapper.EmployeeAddressMapperService;
import com.fractal.domain.employee_management.citizenship.mapper.EmployeeCitizenshipMapperService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.education.mapper.EmployeeEducationMapperService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.employee_management.employee.resource.mapper.EmployeeResourceMapperService;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentMapperService;
import com.fractal.domain.employee_management.identification_document.mapper.EmployeeIdentificationDocumentMapperService;
import com.fractal.domain.employee_management.language_skill.mapper.EmployeeLanguageSkillMapperService;
import com.fractal.domain.employee_management.military_service.mapper.EmployeeMilitaryServiceMapperService;
import com.fractal.domain.employee_management.professional_experience.mapper.EmployeeProfessionalExperienceMapperService;
import com.fractal.domain.employee_management.relative.mapper.RelativeMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EmployeeMapperServiceImpl implements EmployeeMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final EmployeeIdentificationDocumentMapperService identificationDocumentMapperService;
    private final EmployeeCitizenshipMapperService employeeCitizenshipMapperService;
    private final EmployeeAddressMapperService addressMapperService;
    private final EmployeeContactMapperService contactMapperService;
    private final EmployeeEducationMapperService employeeEducationMapperService;
    private final EmployeeLanguageSkillMapperService employeeLanguageSkillMapperService;
    private final RelativeMapperService relativeMapperService;
    private final EmployeeMilitaryServiceMapperService militaryServiceMapperService;
    private final EmployeeResourceMapperService employeeResourceMapperService;
    private final EmployeeEmploymentMapperService employmentMapperService;
    private final EmployeeProfessionalExperienceMapperService professionalExperienceMapperService;

    @Override
    public EmployeeResponse toDTO(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getPatronymicName(),
                employee.getBirthDate(),
                employee.getTin(),
                employee.getSsn(),
                genderService.toDTO(employee.getGender()),
                maritalStatusService.toDTO(employee.getMaritalStatus()),
                nationalityService.toDTO(employee.getNationality()),
                employee.getUuid(),
                Optional.ofNullable(employee.getIdentificationDocuments())
                        .orElse(emptyList())
                        .stream()
                        .map(identificationDocumentMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getCitizenships())
                        .orElse(emptyList())
                        .stream()
                        .map(employeeCitizenshipMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getEducations())
                        .orElse(emptyList())
                        .stream()
                        .map(employeeEducationMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getLanguageSkills())
                        .orElse(emptyList())
                        .stream()
                        .map(employeeLanguageSkillMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getRelatives())
                        .orElse(emptyList())
                        .stream()
                        .map(relativeMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getMilitaryServices())
                        .orElse(emptyList())
                        .stream()
                        .map(militaryServiceMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getEmployments())
                        .orElse(emptyList())
                        .stream()
                        .map(employment -> employmentMapperService.toDTO(employment))
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getProfessionalExperiences())
                        .orElse(emptyList())
                        .stream()
                        .map(professionalExperienceMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(employeeResourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(employee.getStatus()),
                getProfilePhoto(employee),
                employee.getCreatedDate()

        );
    }

    @Override
    public Employee toEntity(EmployeeRequest dto) {
       var employee = mapToEntity(new Employee(), dto);
        employee.setStatus(statusService.getByCode("CREATED"));
        return employee;
    }

    @Override
    public Employee toEntity(Employee employee, EmployeeRequest dto) {
        return mapToEntity(employee, dto);
    }

    @Override
    public EmployeeCompactResponse toCompactDTO(Employee employee) {
        return new EmployeeCompactResponse(
                employee.getId(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getPatronymicName(),
                employee.getBirthDate(),
                employee.getTin(),
                employee.getSsn(),
                genderService.toDTO(employee.getGender()),
                maritalStatusService.toDTO(employee.getMaritalStatus()),
                nationalityService.toDTO(employee.getNationality())
        );
    }

    private Employee mapToEntity(Employee employee, EmployeeRequest dto) {
        employee.setLastName(dto.lastName());
        employee.setFirstName(dto.firstName());
        employee.setPatronymicName(dto.patronymicName());
        employee.setBirthDate(dto.birthDate());
        employee.setTin(dto.tin());
        employee.setSsn(dto.ssn());
        employee.setGender(genderService.getById(dto.genderId()));
        employee.setMaritalStatus(maritalStatusService.getById(dto.maritalStatusId()));
        employee.setNationality(nationalityService.getById(dto.nationalityId()));
        employee.setUuid(dto.uuid());


        dto.identificationDocuments().forEach(identificationDocument -> employee.addIdentificationDocument(identificationDocumentMapperService.toEntity(identificationDocument)));
        dto.citizenships().forEach(citizenship -> employee.addCitizenship(employeeCitizenshipMapperService.toEntity(citizenship)));
        dto.addresses().forEach(address -> employee.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact -> employee.addContact(contactMapperService.toEntity(contact)));
        dto.educations().forEach(education -> employee.addEducation(employeeEducationMapperService.toEntity(education)));
        dto.languageSkills().forEach(languageSkill -> employee.addLanguageSkill(employeeLanguageSkillMapperService.toEntity(languageSkill)));
        dto.relatives().forEach(relative -> employee.addRelative(relativeMapperService.toEntity(relative)));
        dto.militaryServices().forEach(militaryService -> employee.addMilitaryService(militaryServiceMapperService.toEntity(militaryService)));
        dto.employments().forEach(employment -> employee.addEmployment(employmentMapperService.toEntity(employment)));
        dto.professionalExperiences().forEach(professionalExperience -> employee.addProfessionalExperience(professionalExperienceMapperService.toEntity(professionalExperience)));
        dto.resources().forEach(resource -> employee.addResource(employeeResourceMapperService.toEntity(resource, null)));
        return employee;
    }

    private String getProfilePhoto(Employee employee) {
        EmployeeResource resource = employee.getResources()
                .stream()
                .filter(res -> "PROFILE_PHOTO".equals(res.getEmployeeResourceType().getCode()))
                .sorted(Comparator.comparing(EmployeeResource::getId).reversed())
                .findFirst()
                .orElse(null);
        if (resource != null) {
            try {
                Path path = Path.of(resource.getUrl());
                byte[] fileBytes = Files.readAllBytes(path);
                return Base64.getEncoder().encodeToString(fileBytes);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

}
