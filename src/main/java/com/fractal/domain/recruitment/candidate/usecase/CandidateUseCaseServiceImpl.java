package com.fractal.domain.recruitment.candidate.usecase;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.mapper.EmployeeAddressMapperService;
import com.fractal.domain.employee_management.citizenship.mapper.EmployeeCitizenshipMapperService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.education.mapper.EmployeeEducationMapperService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.resource.mapper.EmployeeResourceMapperService;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentMapperService;
import com.fractal.domain.employee_management.identification_document.mapper.EmployeeIdentificationDocumentMapperService;
import com.fractal.domain.employee_management.language_skill.mapper.EmployeeLanguageSkillMapperService;
import com.fractal.domain.employee_management.military_service.mapper.EmployeeMilitaryServiceMapperService;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceRequest;
import com.fractal.domain.employee_management.professional_experience.mapper.EmployeeProfessionalExperienceMapperService;
import com.fractal.domain.recruitment.candidate.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateUseCaseServiceImpl implements CandidateUseCaseService {

    private final CandidateService candidateService;

    private final EmployeeService employeeService;
    private final EmployeeIdentificationDocumentMapperService employeeIdentificationDocumentMapperService;
    private final EmployeeCitizenshipMapperService employeeCitizenshipMapperService;
    private final EmployeeAddressMapperService employeeAddressMapperService;
    private final EmployeeContactMapperService employeeContactMapperService;
    private final EmployeeEducationMapperService employeeEducationMapperService;
    private final EmployeeLanguageSkillMapperService employeeLanguageSkillMapperService;
    private final EmployeeMilitaryServiceMapperService employeeMilitaryServiceMapperService;
    private final EmployeeEmploymentMapperService employeeEmploymentMapperService;
    private final EmployeeResourceMapperService employeeResourceMapperService;
    private final EmployeeProfessionalExperienceMapperService employeeProfessionalExperienceMapperService;


    @Override
    public void hire(Long id) {
        var candidate = candidateService.getById(id);
        Employee employee = Employee.builder()
                .firstName(candidate.getFirstName())
                .lastName(candidate.getLastName())
                .patronymicName(candidate.getPatronymicName())
                .birthDate(candidate.getBirthDate())
                .tin(candidate.getTin())
                .ssn(candidate.getSsn())
                .gender(candidate.getGender())
                .maritalStatus(candidate.getMaritalStatus())
                .nationality(candidate.getNationality())
                .status(candidate.getStatus())
                .build();
        candidate.getIdentificationDocuments().forEach(identificationDocument -> employee.addIdentificationDocument(employeeIdentificationDocumentMapperService.copy(identificationDocument)));
        candidate.getCitizenships().forEach(citizenship -> employee.addCitizenship(employeeCitizenshipMapperService.toEntity(new CitizenshipRequest(citizenship.getCountry().getId()))));
        candidate.getAddresses().forEach(address -> employee.addAddress(employeeAddressMapperService.convert(EmployeeAddress.builder().build(), address)));
        candidate.getContacts().forEach(contact -> employee.addContact(employeeContactMapperService.toEntity(new ContactRequest(contact.getContactType().getId(), contact.getValue()))));
        candidate.getEducations().forEach(education -> employee.addEducation(employeeEducationMapperService.copy(education)));
        candidate.getLanguageSkills().forEach(languageSkill -> employee.addLanguageSkill(employeeLanguageSkillMapperService.toEntity(new LanguageSkillRequest(languageSkill.getLanguage().getId(), languageSkill.getLanguageProficiency().getId()))));
        candidate.getMilitaryServices().forEach(militaryService -> employee.addMilitaryService(employeeMilitaryServiceMapperService.copy(militaryService)));
        candidate.getEmployments().forEach(employment -> employee.addEmployment(employeeEmploymentMapperService.copy(employment.getEmployment())));
        candidate.getResources().forEach(resource -> employee.addResource(employeeResourceMapperService.copy(resource)));
        candidate.getProfessionalExperiences().forEach(professionalExperience -> employee.addProfessionalExperience(employeeProfessionalExperienceMapperService.toEntity(new EmployeeProfessionalExperienceRequest(professionalExperience.getIndustry().getId(), professionalExperience.getYears()))));
        employeeService.save(employee);
    }
}
