package com.fractal.domain.employee_management.employee.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.address.mapper.EmployeeAddressMapperService;
import com.fractal.domain.employee_management.citizenship.mapper.EmployeeCitizenshipMapperService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.education.mapper.EducationMapperService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employee.resource.mapper.EmployeeResourceMapperService;
import com.fractal.domain.employee_management.employment.mapper.EmploymentHistoryMapperService;
import com.fractal.domain.employee_management.identification_document.mapper.IdentificationDocumentMapperService;
import com.fractal.domain.employee_management.military_service.mapper.MilitaryServiceMapperService;
import com.fractal.domain.employee_management.relative.mapper.RelativeMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    private final IdentificationDocumentMapperService identificationDocumentMapperService;
    private final EmployeeCitizenshipMapperService employeeCitizenshipMapperService;
    private final EmployeeAddressMapperService addressMapperService;
    private final EmployeeContactMapperService contactMapperService;
    private final EducationMapperService educationMapperService;
    private final RelativeMapperService relativeMapperService;
    private final MilitaryServiceMapperService militaryServiceMapperService;
    private final EmploymentHistoryMapperService employmentHistoryMapperService;
    private final EmployeeResourceMapperService employeeResourceMapperService;

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
                employee.getGender().getName(),
                employee.getMaritalStatus().getName(),
                employee.getNationality().getName(),
                Optional.ofNullable(employee.getIdentificationDocuments())
                        .orElse(emptyList())
                        .stream()
                        .map(identificationDocumentMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getEmployeeCitizenships())
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
                        .map(educationMapperService::toDTO)
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
                Optional.ofNullable(employee.getEmploymentHistories())
                        .orElse(emptyList())
                        .stream()
                        .map(employmentHistoryMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(employeeResourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                employee.getStatus().getName(),
                employee.getCreatedDate()

        );
    }

    @Override
    public Employee toEntity(EmployeeRequest dto) {
        return mapToEntity(new Employee(),dto);
    }

    @Override
    public Employee toEntity(Employee employee, EmployeeRequest dto) {
       return mapToEntity(employee,dto);
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
        employee.setStatus(statusService.getById(dto.statusId()));

        dto.identificationDocuments().forEach(identificationDocument->employee.addIdentificationDocument(identificationDocumentMapperService.toEntity(identificationDocument)));
        dto.citizenships().forEach(citizenship-> employee.addCitizenship(employeeCitizenshipMapperService.toEntity(citizenship)));
        dto.addresses().forEach(address->employee.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact->employee.addContact(contactMapperService.toEntity(contact)));
        dto.educations().forEach(education->employee.addEducation(educationMapperService.toEntity(education)));
        dto.relatives().forEach(relative->employee.addRelative(relativeMapperService.toEntity(relative)));
        dto.militaryServices().forEach(militaryService->employee.addMilitaryService(militaryServiceMapperService.toEntity(militaryService)));
        dto.employmentHistories().forEach(employmentHistory->employee.addEmploymentHistory(employmentHistoryMapperService.toEntity(employmentHistory)));
        dto.files().forEach(file-> employee.addResource(employeeResourceMapperService.toEntity(file,null)));
       return employee;
    }

}
