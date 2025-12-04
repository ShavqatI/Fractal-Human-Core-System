package com.fractal.domain.employee_management.employee;

import com.fractal.component.CurrentUserHolder;
import com.fractal.component.SpringContext;
import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employee.mapper.EmployeeMapperService;
import com.fractal.domain.employee_management.employee.state.EmployeeStateService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapperService employeeMapperService;
    private final StatusService statusService;
    private final EmployeeStateService stateService;


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
        return save(employeeMapperService.toEntity(findById(id), dto));
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
    public EmployeeCompactResponse toCompactDTO(Employee employee) {
        return employeeMapperService.toCompactDTO(employee);
    }

    @Override
    public Employee save(Employee employee) {
        try {
            employee = employeeRepository.save(employee);
            stateService.create(employee);
            return employee;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }




    private Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " not found"));
    }


    @Override
    public Employee review(Long id) {
        var employee = getById(id);
        if (employee.getStatus().getCode().equals("CREATED")) {
            employee.setReviewedDate(LocalDateTime.now());
            //employee.setReviewedUser(authenticatedService.getUser());
            employee.setStatus(statusService.getByCode("REVIEWED"));
            stateService.create(employee);
            return employee;
        } else {
            throw new ResourceStateException("The status is not valid is: " + employee.getStatus().getName());
        }
    }

    @Override
    public Employee approve(Long id) {
        var employee = getById(id);
        if (employee.getStatus().getCode().equals("REVIEWED")) {
            employee.setApprovedDate(LocalDateTime.now());
            CurrentUserHolder currentUserHolder = SpringContext.getBean(CurrentUserHolder.class);
            employee.setReviewedUser(currentUserHolder.get());
            employee.setStatus(statusService.getByCode("APPROVED"));
            stateService.create(employee);
            return employee;
        } else {
            throw new ResourceStateException("The status is not valid is: " + employee.getStatus().getName());
        }
    }

    @Override
    public void activate(Long id) {
        var employee = getById(id);
        if (employee.getStatus().getCode().equals("APPROVED")) {
            employee.setApprovedDate(LocalDateTime.now());
            CurrentUserHolder currentUserHolder = SpringContext.getBean(CurrentUserHolder.class);
            employee.setApprovedUser(currentUserHolder.get());
            employee.setStatus(statusService.getByCode("ACTIVE"));
            stateService.create(employee);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employee.getStatus().getName());
        }
    }
}