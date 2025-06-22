package com.fractal.domain.employee_management.employee;

import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employee.mapper.EmployeeMapperService;
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
    private final EmployeeMapperService employeeMapperService;

    @Override
    @Transactional
    public Employee create(EmployeeRequest dto) {
        return save(employeeMapperService.toEntity(dto));
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
        var employee = employeeMapperService.toEntity(findById(id),dto);
        return employee;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      employeeRepository.delete(findById(id));
    }

    @Override
    public EmployeeResponse toDTO(Employee employee) {
       return employeeMapperService.toDTO(employee);
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