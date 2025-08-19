package com.fractal.domain.military_service;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.military_service.mapper.MilitaryServiceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class MilitaryServiceServiceImpl implements MilitaryServiceService {

    private final MilitaryServiceRepository militaryServiceRepository;


/*

    @Override
    @Transactional
    public MilitaryService create(Long employeeId, MilitaryServiceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var militaryService = militaryServiceMapperService.toEntity(dto);
        employee.addMilitaryService(militaryService);
        employeeService.save(employee);
       return militaryService;
    }

    @Override
    public List<MilitaryService> getAllByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public MilitaryService getById(Long employeeId, Long id) {
        return null;
    }

    @Override
    @Transactional
    public MilitaryService update(Long employeeId, Long id, MilitaryServiceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var militaryService = employee.getMilitaryServices()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
        militaryService = militaryServiceMapperService.toEntity(militaryService,dto);
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
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
        employee.removeMilitaryService(militaryService);
        militaryServiceRepository.delete(militaryService);
        employeeService.save(employee);
    }

    @Override
    public MilitaryServiceResponse toDTO(MilitaryService militaryService) {
        return militaryServiceMapperService.toDTO(militaryService);
    }

*/

    @Override
    public MilitaryService getById(Long id) {
        return findById(id);
    }

    @Override
    public MilitaryService save(MilitaryService militaryService) {
        try {
            return militaryServiceRepository.save(militaryService);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
    private MilitaryService findById(Long id) {
        return militaryServiceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Military service  with id: " + id + " not found"));
    }
}
