package com.fractal.domain.employee_management.employee;


import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.identification_document.type.IdentificationDocumentTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final IdentificationDocumentTypeService identificationDocumentTypeService;

    @Override
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
    public Employee update(Long id, EmployeeRequest dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
      employeeRepository.delete(findById(id));
    }

    @Override
    public EmployeeResponse toDTO(Employee employee) {
        return null;
    }

    private Employee toEntity(EmployeeRequest dto) {
        return Employee.builder().build();
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