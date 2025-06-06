package com.fractal.domain.employee_management.employee;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.address.EmployeeAddressService;
import com.fractal.domain.employee_management.citizenship.CitizenshipService;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employment.EmploymentHistoryService;
import com.fractal.domain.employee_management.identification_document.IdentificationDocumentService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final IdentificationDocumentService identificationDocumentService;
    private final CitizenshipService citizenshipService;
    private final EmployeeAddressService addressService;
    private final EmploymentHistoryService employmentHistoryService;

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
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      employeeRepository.delete(findById(id));
    }

    @Override
    public EmployeeResponse toDTO(Employee employee) {
        return null;
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
        dto.addresses().forEach(address->employee.addAddress(addressService.toEntity(address)));
        dto.employmentHistories().forEach(employmentHistory->employee.addEmploymentHistory(employmentHistoryService.toEntity(employmentHistory)));
        return employee;
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