package com.fractal.domain.employee_management.employment;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;
import com.fractal.domain.employee_management.employment.mapper.EmploymentHistoryMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmploymentHistoryServiceImpl implements EmploymentHistoryService {

    private final EmploymentHistoryRepository employmentHistoryRepository;
    private final EmploymentHistoryMapperService employmentHistoryMapperService;
    private final EmployeeService employeeService;

    @Override
    @Transactional
    public EmploymentHistory create(Long employeeId, EmploymentHistoryRequest dto) {
        var employee = employeeService.getById(employeeId);
        var employmentHistory = employmentHistoryMapperService.toEntity(dto);
        //employee.addEmploymentHistory(employmentHistory);
        employeeService.save(employee);
        return employmentHistory;
    }

    @Override
    public List<EmploymentHistory> getAllByEmployeeId(Long employeeId) {
        return employmentHistoryRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmploymentHistory getById(Long employeeId, Long id) {
        return employmentHistoryRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + id + " not found"));
    }

    @Override
    public EmploymentHistory getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public EmploymentHistory update(Long employeeId, Long id, EmploymentHistoryRequest dto) {
        var employee = employeeService.getById(employeeId);
        /*var employmentHistory = employee.getEmploymentHistories()
                .stream()
                .filter(eh-> eh.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + id + " not found"));
        employmentHistory = employmentHistoryMapperService.toEntity(employmentHistory,dto);
        employmentHistoryRepository.save(employmentHistory);
        employeeService.save(employee);*/
        return null;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        /*var employee = employeeService.getById(employeeId);
        var employmentHistory = employee.getEmploymentHistories()
                .stream()
                .filter(eh-> eh.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + id + " not found"));
        employee.removeEmploymentHistory(employmentHistory);
        employmentHistoryRepository.delete(employmentHistory);
        employeeService.save(employee);*/
    }

    @Override
    public EmploymentHistory save(EmploymentHistory employmentHistory) {
        try {
           return employmentHistoryRepository.save(employmentHistory);
        }
        catch (DataAccessException e){
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public EmploymentHistoryResponse toDTO(EmploymentHistory employmentHistory) {
        return employmentHistoryMapperService.toDTO(employmentHistory);
    }
    private EmploymentHistory findById(Long id) {
        return employmentHistoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + id + " not found"));
    }
}
