package com.fractal.domain.employee_management.military_service;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.military_service.mapper.EmployeeMilitaryServiceMapperService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeMilitaryServiceServiceImpl implements EmployeeMilitaryServiceService {

    private final EmployeeMilitaryServiceRepository militaryServiceRepository;
    private final EmployeeMilitaryServiceMapperService militaryServiceMapperService;
    private final EmployeeService employeeService;

    @Override
    @Transactional
    public EmployeeMilitaryService create(Long employeeId, MilitaryServiceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var militaryService = militaryServiceMapperService.toEntity(dto);
        employee.addMilitaryService(militaryService);
        employeeService.save(employee);
        return militaryService;
    }

    @Override
    public List<EmployeeMilitaryService> getAllByEmployeeId(Long employeeId) {
        return militaryServiceRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeMilitaryService getById(Long employeeId, Long id) {
        return militaryServiceRepository.findByEmployeeIdAndId(employeeId, id).orElseThrow(() -> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public EmployeeMilitaryService update(Long employeeId, Long id, MilitaryServiceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var militaryService = employee.getMilitaryServices()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
        militaryService = militaryServiceMapperService.toEntity(militaryService, dto);
        militaryServiceRepository.save(militaryService);
        employeeService.save(employee);
        return militaryService;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var militaryService = employee.getMilitaryServices()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
        employee.removeMilitaryService(militaryService);
        employeeService.save(employee);
    }

    @Override
    public MilitaryServiceResponse toDTO(EmployeeMilitaryService employeeMilitaryService) {
        return militaryServiceMapperService.toDTO(employeeMilitaryService);
    }


    @Override
    public EmployeeMilitaryService getById(Long id) {
        return findById(id);
    }

    @Override
    public EmployeeMilitaryService save(EmployeeMilitaryService employeeMilitaryService) {
        try {
            return militaryServiceRepository.save(employeeMilitaryService);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmployeeMilitaryService findById(Long id) {
        return militaryServiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Military service  with id: " + id + " not found"));
    }
}
