package com.fractal.domain.integration.mapping.employee;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.integration.mapping.employee.dto.EmployeeMappingRequest;
import com.fractal.domain.integration.mapping.employee.dto.EmployeeMappingResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class EmployeeMappingServiceImpl implements EmployeeMappingService {

    private final EmployeeMappingRepository employeeMappingRepository;
    private final EmployeeService employeeService;
    private final StatusService statusService;

    @Override
    public EmployeeMapping create(EmployeeMappingRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<EmployeeMapping> getAll() {
        return employeeMappingRepository.findAll();
    }

    @Override
    public EmployeeMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public EmployeeMapping update(Long id, EmployeeMappingRequest dto) {
        try {
            EmployeeMapping employeeMapping = findById(id);
            employeeMapping.setEmployee(employeeService.getById(dto.employeeId()));
            employeeMapping.setReferenceType(dto.referenceType());
            employeeMapping.setReference(dto.reference());
            employeeMapping.setStatus(statusService.getById(dto.statusId()));
            return save(employeeMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        employeeMappingRepository.delete(findById(id));
    }

    @Override
    public EmployeeMappingResponse toDTO(EmployeeMapping employeeMapping) {
        return new EmployeeMappingResponse(
                employeeMapping.getId(),
                employeeService.toCompactDTO(employeeMapping.getEmployee()),
                employeeMapping.getReferenceType(),
                employeeMapping.getReference(),
                statusService.toCompactDTO(employeeMapping.getStatus()),
                employeeMapping.getCreatedDate()
        );
    }

    private EmployeeMapping toEntity(EmployeeMappingRequest dto) {
        return EmployeeMapping.builder()
                .employee(employeeService.getById(dto.employeeId()))
                .referenceType(dto.referenceType())
                .reference(dto.reference())
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private EmployeeMapping save(EmployeeMapping employeeMapping) {
        try {
            return employeeMappingRepository.save(employeeMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmployeeMapping findById(Long id) {
        return employeeMappingRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
