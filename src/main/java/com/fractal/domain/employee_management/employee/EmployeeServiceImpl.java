package com.fractal.domain.employee_management.employee;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.EmployeeAddressDomainService;
import com.fractal.domain.employee_management.address.EmployeeAddressService;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.citizenship.CitizenshipService;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.contact.EmployeeContactService;
import com.fractal.domain.employee_management.education.EducationService;
import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employee.resource.EmployeeResourceService;
import com.fractal.domain.employee_management.employment.EmploymentHistoryService;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.identification_document.IdentificationDocumentService;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.military_service.MilitaryServiceService;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employee_management.relative.RelativeService;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
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
class EmployeeServiceImpl implements EmployeeService, EmployeeAddressService {

    private final EmployeeRepository employeeRepository;

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final IdentificationDocumentService identificationDocumentService;
    private final CitizenshipService citizenshipService;
    private final EmployeeAddressDomainService addressDomainService;
    private final EmployeeContactService contactService;
    private final EducationService educationService;
    private final RelativeService relativeService;
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

        dto.identificationDocuments().forEach(identificationDocument->employee.addIdentificationDocument(identificationDocumentService.toEntity(identificationDocument)));
        dto.citizenships().forEach(citizenship-> employee.addCitizenship(citizenshipService.toEntity(citizenship)));
        dto.addresses().forEach(address->employee.addAddress(addressDomainService.toEntity(address)));
        dto.contacts().forEach(contact->employee.addContact(contactService.toEntity(contact)));
        dto.educations().forEach(education->employee.addEducation(educationService.toEntity(education)));
        dto.relatives().forEach(relative->employee.addRelative(relativeService.toEntity(relative)));
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
                        .map(identificationDocumentService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getCitizenships())
                        .orElse(emptyList())
                        .stream()
                        .map(citizenshipService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressDomainService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getEducations())
                        .orElse(emptyList())
                        .stream()
                        .map(educationService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employee.getRelatives())
                        .orElse(emptyList())
                        .stream()
                        .map(relativeService::toDTO)
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
        dto.identificationDocuments().forEach(identificationDocument->employee.addIdentificationDocument(identificationDocumentService.toEntity(identificationDocument)));
        dto.citizenships().forEach(citizenship-> employee.addCitizenship(citizenshipService.toEntity(citizenship)));
        dto.addresses().forEach(address->employee.addAddress(addressDomainService.toEntity(address)));
        dto.contacts().forEach(contact->employee.addContact(contactService.toEntity(contact)));
        dto.educations().forEach(education->employee.addEducation(educationService.toEntity(education)));
        dto.relatives().forEach(relative->employee.addRelative(relativeService.toEntity(relative)));
        dto.militaryServices().forEach(militaryService->employee.addMilitaryService(militaryServiceService.toEntity(militaryService)));
        dto.employmentHistories().forEach(employmentHistory->employee.addEmploymentHistory(employmentHistoryService.toEntity(employmentHistory)));
        dto.files().forEach(file-> employee.addResource(resourceService.toEntity(file,null)));
        return employee;
    }

    @Override
    @Transactional
    public Employee addIdentificationDocument(Long id, IdentificationDocumentRequest dto) {
        var employee = findById(id);
        employee.addIdentificationDocument(identificationDocumentService.toEntity(dto));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateIdentificationDocument(Long id, Long identificationDocumentId, IdentificationDocumentRequest dto) {
        var employee = findById(id);
        var identificationDocument = employee.getIdentificationDocuments()
                .stream()
                .filter(i-> i.getId().equals(identificationDocumentId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + identificationDocumentId + " not found"));
        identificationDocumentService.update(identificationDocument.getId(),dto);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteIdentificationDocument(Long id, Long identificationDocumentId) {
        var employee = findById(id);
        var identificationDocument = employee.getIdentificationDocuments()
                .stream()
                .filter(i -> i.getId().equals(identificationDocumentId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + identificationDocumentId + " not found"));
        employee.removeIdentificationDocument(identificationDocument);
        identificationDocumentService.delete(identificationDocument);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee addCitizenship(Long id, CitizenshipRequest dto) {
        var employee = findById(id);
        employee.addCitizenship(citizenshipService.toEntity(dto));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateCitizenship(Long id, Long citizenshipId, CitizenshipRequest dto) {
        var employee = findById(id);
        var citizenship = employee.getCitizenships()
                .stream()
                .filter(c-> c.getId().equals(citizenshipId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + citizenshipId + " not found"));
        citizenshipService.update(citizenship.getId(),dto);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteCitizenship(Long id, Long citizenshipId) {
        var employee = findById(id);
        var citizenship = employee.getCitizenships()
                .stream()
                .filter(c-> c.getId().equals(citizenshipId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + citizenshipId + " not found"));
        employee.removeCitizenship(citizenship);
        citizenshipService.delete(citizenship);
        return save(employee);
    }




    @Override
    @Transactional
    public EmployeeAddress addAddress(Long id, EmployeeAddressRequest dto) {
        var employee = findById(id);
        EmployeeAddress address = addressDomainService.toEntity(dto);
        employee.addAddress(address);
        save(employee);
        return address;
    }


    @Override
    @Transactional
    public EmployeeAddress updateAddress(Long id, Long addressId, EmployeeAddressRequest dto) {
        var employee = findById(id);
        var address = employee.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee address with id: " + addressId + " not found"));
        address = addressDomainService.update(address,dto);
        save(employee);
        return address;
    }

    @Override
    @Transactional
    public void deleteAddress(Long id, Long addressId) {
        var employee = findById(id);
        var address = employee.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee address with id: " + addressId + " not found"));
        employee.removeAddress(address);
        addressDomainService.delete(address);
    }

    @Override
    public EmployeeAddressResponse toDTO(EmployeeAddress address) {
        return addressDomainService.toDTO(address);
    }

    @Override
    public Employee addContact(Long id, ContactRequest dto) {
        var employee = findById(id);
        employee.addContact(contactService.toEntity(dto));
        return save(employee);
    }

    @Override
    public Employee updateContact(Long id, Long contactId, ContactRequest dto) {
        var employee = findById(id);
        var contact = employee.getContacts()
                .stream()
                .filter(c-> c.getId().equals(contactId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + contactId + " not found"));
        contactService.update(contact.getId(),dto);
        return save(employee);
    }

    @Override
    public Employee deleteContact(Long id, Long contactId) {
        var employee = findById(id);
        var contact = employee.getContacts()
                .stream()
                .filter(c-> c.getId().equals(contactId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + contactId + " not found"));
        employee.removeContact(contact);
        contactService.delete(contact);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee addEducation(Long id, EducationRequest dto) {
        var employee = findById(id);
        employee.addEducation(educationService.toEntity(dto));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateEducation(Long id, Long educationId, EducationRequest dto) {
        var employee = findById(id);
        var education = employee.getEducations()
                .stream()
                .filter(e-> e.getId().equals(educationId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + educationId + " not found"));
        educationService.update(education.getId(),dto);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteEducation(Long id, Long educationId) {
        var employee = findById(id);
        var education = employee.getEducations()
                .stream()
                .filter(e-> e.getId().equals(educationId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + educationId + " not found"));
        employee.removeEducation(education);
        educationService.delete(education);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee addRelative(Long id, RelativeRequest dto) {
        var employee = findById(id);
        employee.addRelative(relativeService.toEntity(dto));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateRelative(Long id, Long relativeId, RelativeRequest dto) {
        var employee = findById(id);
        var relative = employee.getRelatives()
                .stream()
                .filter(r-> r.getId().equals(relativeId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative with id: " + relativeId + " not found"));
        relativeService.update(relative.getId(),dto);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteRelative(Long id, Long relativeId) {
        var employee = findById(id);
        var relative = employee.getRelatives()
                .stream()
                .filter(r-> r.getId().equals(relativeId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative with id: " + relativeId + " not found"));
        employee.removeRelative(relative);
        relativeService.delete(relative);
        return save(employee);
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

    private Employee save(Employee employee) {
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