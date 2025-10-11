package com.fractal.domain.employee_management.employment;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentMapperService;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.ExternalEmploymentService;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeEmploymentServiceImpl implements EmployeeEmploymentService {

    private final EmployeeEmploymentRepository employmentRepository;
    private final EmployeeService employeeService;
    private final InternalEmploymentService internalEmploymentService;
    private final ExternalEmploymentService externalEmploymentService;
    private final EmployeeEmploymentMapperService employmentMapperService;

    @Override
    @Transactional
    public EmployeeEmployment create(Long employeeId,EmploymentRequest dto) {
        Employment employment = null;
        if (dto instanceof InternalEmploymentRequest) {
            employment = internalEmploymentService.create((InternalEmploymentRequest) dto);
        } else if (dto instanceof ExternalEmploymentRequest ) {
            employment = externalEmploymentService.create((ExternalEmploymentRequest) dto);
        }
        var employeeEmployment = EmployeeEmployment.builder().employment(employment).build();
        var employee = employeeService.getById(employeeId);
        employee.addEmployment(employeeEmployment);
        employeeService.save(employee);
        return employeeEmployment;
    }

    @Override
    public EmployeeEmployment getById(Long employeeId, Long id) {
        return employmentRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public List<EmployeeEmployment> getAllByEmployeeId(Long employeeId) {
        return employmentRepository.findAllByEmployeeId(employeeId);
    }


    @Override
    public EmployeeEmployment update(Long employeeId, Long id, EmploymentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var employeeEmployment = employee.getEmployments()
                .stream()
                .filter(eh-> eh.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        if (dto instanceof InternalEmploymentRequest) {
            internalEmploymentService.update(employeeEmployment.getEmployment().getId(),(InternalEmploymentRequest) dto);
        } else if (dto instanceof ExternalEmploymentRequest ) {
            externalEmploymentService.update(employeeEmployment.getEmployment().getId(),(ExternalEmploymentRequest) dto);
        }
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
        return employmentMapperService.toDTO(employment);
    }
}
