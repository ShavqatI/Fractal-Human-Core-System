package com.fractal.domain.employee_management.employee;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.address.mapper.EmployeeAddressMapperService;
import com.fractal.domain.employee_management.citizenship.mapper.CitizenshipMapperService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.education.mapper.EducationMapperService;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employee.resource.EmployeeResourceService;
import com.fractal.domain.employee_management.employment.EmploymentHistoryService;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.identification_document.mapper.IdentificationDocumentMapperService;
import com.fractal.domain.employee_management.military_service.MilitaryServiceService;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employee_management.relative.mapper.RelativeMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final IdentificationDocumentMapperService identificationDocumentMapperService;
    private final CitizenshipMapperService citizenshipMapperService;
    private final EmployeeAddressMapperService addressMapperService;
    private final EmployeeContactMapperService contactMapperService;
    private final EducationMapperService educationMapperService;
    private final RelativeMapperService relativeMapperService;
    private final MilitaryServiceService militaryServiceService;
    private final EmploymentHistoryService employmentHistoryService;
    private final EmployeeResourceService resourceService;

    @Override
    @Transactional
    public Employee create(EmployeeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getByTin(String tin) {
        return employeeRepository.findByTin(tin).orElseThrow(() -> new ResourceNotFoundException("Employee with tin: " + tin + " not found"));
    }

    @Override
    public Employee getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Employee update(Long id, EmployeeRequest dto) {
        var employee = findById(id);
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
        dto.citizenships().forEach(citizenship-> employee.addCitizenship(citizenshipMapperService.toEntity(citizenship)));
        dto.addresses().forEach(address->employee.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact->employee.addContact(contactMapperService.toEntity(contact)));
        dto.educations().forEach(education->employee.addEducation(educationMapperService.toEntity(education)));
        dto.relatives().forEach(relative->employee.addRelative(relativeMapperService.toEntity(relative)));
        dto.militaryServices().forEach(militaryService->employee.addMilitaryService(militaryServiceService.toEntity(militaryService)));
        dto.employmentHistories().forEach(employmentHistory->employee.addEmploymentHistory(employmentHistoryService.toEntity(employmentHistory)));
       return employee;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      employeeRepository.delete(findById(id));
    }

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
                Optional.ofNullable(employee.getCitizenships())
                        .orElse(emptyList())
                        .stream()
                        .map(citizenshipMapperService::toDTO)
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
                        .map(militaryServiceService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getEmploymentHistories())
                        .orElse(emptyList())
                        .stream()
                        .map(employmentHistoryService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceService::toDTO)
                        .collect(Collectors.toList()),
                employee.getStatus().getName(),
                employee.getCreatedDate()

        );
    }

    private Employee toEntity(EmployeeRequest dto) {
        var employee = Employee.builder()
                .lastName(dto.lastName())
                .firstName(dto.firstName())
                .patronymicName(dto.patronymicName())
                .birthDate(dto.birthDate())
                .tin(dto.tin())
                .ssn(dto.ssn())
                .gender(genderService.getById(dto.genderId()))
                .maritalStatus(maritalStatusService.getById(dto.maritalStatusId()))
                .nationality(nationalityService.getById(dto.nationalityId()))
                .status(statusService.getById(dto.statusId()))
                .build();
        dto.identificationDocuments().forEach(identificationDocument->employee.addIdentificationDocument(identificationDocumentMapperService.toEntity(identificationDocument)));
        dto.citizenships().forEach(citizenship-> employee.addCitizenship(citizenshipMapperService.toEntity(citizenship)));
        dto.addresses().forEach(address->employee.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact->employee.addContact(contactMapperService.toEntity(contact)));
        dto.educations().forEach(education->employee.addEducation(educationMapperService.toEntity(education)));
        dto.relatives().forEach(relative->employee.addRelative(relativeMapperService.toEntity(relative)));
        dto.militaryServices().forEach(militaryService->employee.addMilitaryService(militaryServiceService.toEntity(militaryService)));
        dto.employmentHistories().forEach(employmentHistory->employee.addEmploymentHistory(employmentHistoryService.toEntity(employmentHistory)));
        dto.files().forEach(file-> employee.addResource(resourceService.toEntity(file,null)));
        return employee;
    }

    @Override
    @Transactional
    public Employee addMilitaryService(Long id, MilitaryServiceRequest dto) {
        var employee = findById(id);
        employee.addMilitaryService(militaryServiceService.toEntity(dto));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateMilitaryService(Long id, Long militaryServiceId, MilitaryServiceRequest dto) {
        var employee = findById(id);
        var militaryService = employee.getMilitaryServices()
                .stream()
                .filter(m-> m.getId().equals(militaryServiceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Military Service with id: " + militaryServiceId + " not found"));
        militaryServiceService.update(militaryService.getId(),dto);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteMilitaryService(Long id, Long militaryServiceId) {
        var employee = findById(id);
        var militaryService = employee.getMilitaryServices()
                .stream()
                .filter(m-> m.getId().equals(militaryServiceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Military Service with id: " + militaryServiceId + " not found"));
        employee.removeMilitaryService(militaryService);
        militaryServiceService.delete(militaryService);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee addEmploymentHistory(Long id, EmploymentHistoryRequest dto) {
        var employee = findById(id);
        employee.addEmploymentHistory(employmentHistoryService.toEntity(dto));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmploymentHistory(Long id, Long employmentHistoryId, EmploymentHistoryRequest dto) {
        var employee = findById(id);
        var employmentHistory = employee.getEmploymentHistories()
                .stream()
                .filter(eh-> eh.getId().equals(employmentHistoryId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + employmentHistoryId + " not found"));
        employmentHistoryService.update(employmentHistory.getId(),dto);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteEmploymentHistory(Long id, Long employmentHistoryId) {
        var employee = findById(id);
        var employmentHistory = employee.getEmploymentHistories()
                .stream()
                .filter(eh-> eh.getId().equals(employmentHistoryId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + employmentHistoryId + " not found"));
        employee.removeEmploymentHistory(employmentHistory);
        employmentHistoryService.delete(employmentHistory);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee addResource(Long id, MultipartFile file, String url) {
        var employee = findById(id);
        var resource = resourceService.toEntity(file,url);
        employee.addResource(resource);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateResource(Long id, Long resourceId, MultipartFile file) {
        var employee = findById(id);
        var resource = employee.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee Resource  with id: " + resourceId + " not found"));
        resourceService.update(resource,resourceService.fileToRequest(file,null));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteResource(Long id, Long resourceId) {
        var employee = findById(id);
        var resource = employee.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee Resource  with id: " + resourceId + " not found"));
        employee.removeResource(resource);
        resourceService.delete(resource);
        return save(employee);
    }

    @Override
    public Employee save(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " not found"));
    }
}