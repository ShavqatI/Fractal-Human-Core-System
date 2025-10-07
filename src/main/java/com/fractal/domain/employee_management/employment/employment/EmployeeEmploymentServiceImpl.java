package com.fractal.domain.employee_management.employment.employment;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.ExternalEmploymentService;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.mapper.EmploymentMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeEmploymentServiceImpl implements EmployeeEmploymentService {

    private final EmployeeEmploymentRepository employmentRepository;
    private final EmployeeService employeeService;
    private final InternalEmploymentService internalEmploymentService;
    private final ExternalEmploymentService externalEmploymentService;
    private final EmploymentMapperService employmentMapperService;
    @Override
    @Transactional
    public EmployeeEmployment create(Long employeeId, InternalEmploymentRequest dto) {
        var employment = internalEmploymentService.create(dto);
        var employeeEmployment = build(employment);
        var employee = employeeService.getById(employeeId);
        employee.addEmployment(employeeEmployment);
        employeeService.save(employee);
        return employeeEmployment;
    }

    @Override
    @Transactional
    public EmployeeEmployment create(Long employeeId, ExternalEmploymentRequest dto) {
        var employment = externalEmploymentService.create(dto);
        var employeeEmployment = build(employment);
        var employee = employeeService.getById(employeeId);
        employee.addEmployment(employeeEmployment);
        employeeService.save(employee);
        return employeeEmployment;
    }

    @Override
    @Transactional
    public EmployeeEmployment update(Long employeeId, Long id, InternalEmploymentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var employeeEmployment = employee.getEmployments()
                .stream()
                .filter(eh-> eh.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        internalEmploymentService.update(employeeEmployment.getEmployment().getId(),dto);
        employmentRepository.save(employeeEmployment);
        employeeService.save(employee);
        return employeeEmployment;

    }

    @Override
    @Transactional
    public EmployeeEmployment update(Long employeeId, Long id, ExternalEmploymentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var employeeEmployment = employee.getEmployments()
                .stream()
                .filter(eh-> eh.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        externalEmploymentService.update(employeeEmployment.getEmployment().getId(),dto);
        employmentRepository.save(employeeEmployment);
        employeeService.save(employee);
        return employeeEmployment;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var employeeEmployment = employee.getEmployments()
                .stream()
                .filter(eh-> eh.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        employee.removeEmployment(employeeEmployment);
        employeeService.save(employee);
    }

    @Override
    public EmploymentResponse toDTO(EmployeeEmployment employment) {
        return employmentMapperService.toDTO(employment.getEmployment());
    }

    private EmployeeEmployment build(Employment employment) {
        return EmployeeEmployment.builder()
                .employment(employment)
                .build();
    }

}
