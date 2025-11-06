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
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentMapperService;
import com.fractal.domain.employee_management.identification_document.mapper.EmployeeIdentificationDocumentMapperService;
import com.fractal.domain.employee_management.language_skill.mapper.EmployeeLanguageSkillMapperService;
import com.fractal.domain.employee_management.military_service.mapper.EmployeeMilitaryServiceMapperService;
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
              .build();
      /* candidate.getIdentificationDocuments().forEach(identificationDocument -> employee.addIdentificationDocument(employeeIdentificationDocumentMapperService.convert(
               EmployeeIdentificationDocument.builder().build(), identificationDocument
       )));*/

        /*candidate.getIdentificationDocuments().stream().map(identificationDocument -> {identificationDocument.setResources(new ArrayList<>(identificationDocument.getResources()));return identificationDocument;})
                .forEach(identificationDocument ->employee.addIdentificationDocument(employeeIdentificationDocumentMapperService.convert(EmployeeIdentificationDocument.builder().build(),identificationDocument)));
*/

      candidate.getCitizenships().forEach(citizenship -> employee.addCitizenship(employeeCitizenshipMapperService.toEntity(new CitizenshipRequest(citizenship.getCountry().getId()))));
      candidate.getAddresses().forEach(address-> employee.addAddress(employeeAddressMapperService.convert(EmployeeAddress.builder().build(),address)));
      candidate.getContacts().forEach(contact -> employee.addContact(employeeContactMapperService.toEntity(new ContactRequest(contact.getContactType().getId(),contact.getValue()))));

        /*candidate.getEducations().stream().map(education -> {education.setResources(new ArrayList<>(education.getResources())); return education; })
                .forEach(education -> employee.addEducation(employeeEducationMapperService.convert(EmployeeEducation.builder().build(),education)));
*/
      //candidate.getEducations().stream().map(education-> education.getResources()).forEach(education-> employee.addEducation(employeeEducationMapperService.convert(EmployeeEducation.builder().build(),education)));

      candidate.getLanguageSkills().forEach(languageSkill -> employee.addLanguageSkill(employeeLanguageSkillMapperService.toEntity(new LanguageSkillRequest(languageSkill.getLanguage().getId(),languageSkill.getLanguageProficiency().getId()))));
      //candidate.getMilitaryServices().forEach(militaryService -> employee.addMilitaryService(employeeMilitaryServiceMapperService.convert(EmployeeMilitaryService.builder().build(),militaryService)));
/*

        candidate.getMilitaryServices().stream().map(militaryService -> {militaryService.setResources(new ArrayList<>(militaryService.getResources()));return militaryService;})
                .forEach(militaryService -> employee.addMilitaryService(employeeMilitaryServiceMapperService.convert(EmployeeMilitaryService.builder().build(), militaryService)));
*/

      candidate.getEmployments().forEach(employment -> employee.addEmployment(employeeEmploymentMapperService.copy(employment.getEmployment())));
      employeeService.save(employee);
    }
}
