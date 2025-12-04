package com.fractal.domain.employee_management.employment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentApprovedMapperService;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentMapperService;
import com.fractal.domain.employee_management.employment.state.ApprovalWorkflowAwareRequest;
import com.fractal.domain.employee_management.employment.state.EmployeeEmploymentState;
import com.fractal.domain.employee_management.employment.state.EmployeeEmploymentStateService;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.EmploymentService;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.ExternalEmploymentService;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentServiceImpl implements EmployeeEmploymentService {

    private final EmployeeEmploymentRepository employmentRepository;
    private final EmployeeService employeeService;
    private final InternalEmploymentService internalEmploymentService;
    private final ExternalEmploymentService externalEmploymentService;
    private final EmployeeEmploymentMapperService employmentMapperService;
    private final EmployeeEmploymentApprovedMapperService employmentApprovedMapperService;
    private final AuthenticatedService authenticatedService;
    private final EmployeeEmploymentStateService stateService;
    private final StatusService statusService;
    private final EmploymentService employmentService;


    @Override
    @Transactional
    public EmployeeEmployment create(Long employeeId, EmploymentRequest dto) {
        Employment employment = null;
        if (dto instanceof InternalEmploymentRequest) {
            employment = internalEmploymentService.create((InternalEmploymentRequest) dto);
        } else if (dto instanceof ExternalEmploymentRequest) {
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
        return employmentRepository.findByEmployeeIdAndEmploymentId(employeeId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    public EmployeeEmployment getById(Long id) {
        return employmentRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public List<EmployeeEmployment> getAllByEmployeeId(Long employeeId) {
        return employmentRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeEmployment> getAllActive() {
        return employmentRepository.findAllByEmploymentEndDateIsNullAndEmploymentStatusCode("ACTIVE");
    }

    @Override
    public List<EmployeeEmployment> getAllApproved() {
       return employmentRepository.findAllByEmploymentEndDateIsNullAndEmploymentStatusCode("APPROVED")
                .stream().filter(employeeEmployment -> {
                    var employeeEmployment1 = (EmployeeEmployment) Hibernate.unproxy(employeeEmployment);
                    var employment = (Employment) Hibernate.unproxy(employeeEmployment1.getEmployment());
                    return employment instanceof InternalEmployment;
                }).collect(Collectors.toList());
    }


    @Override
    public EmployeeEmployment update(Long employeeId, Long id, EmploymentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var employeeEmployment = employee.getEmployments()
                .stream()
                .filter(eh -> eh.getEmployment().getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        if (dto instanceof InternalEmploymentRequest) {
            internalEmploymentService.update(employeeEmployment.getEmployment().getId(), (InternalEmploymentRequest) dto);
        } else if (dto instanceof ExternalEmploymentRequest) {
            externalEmploymentService.update(employeeEmployment.getEmployment().getId(), (ExternalEmploymentRequest) dto);
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
                .filter(eh -> eh.getEmployment().getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        employee.removeEmployment(employeeEmployment);
        employeeService.save(employee);
    }

    @Override
    public EmploymentResponse toDTO(EmployeeEmployment employment) {
        return employmentMapperService.toDTO(employment);
    }

    @Override
    public InternalEmploymentApprovedResponse toApprovedDTO(EmployeeEmployment employment) {
        return employmentApprovedMapperService.toDTO(employment);
    }

    @Override
    public EmployeeEmployment review(ApprovalWorkflowAwareRequest dto) {
        var employeeEmployment = getById(dto.employeeId(),dto.id());
        if (employeeEmployment.getStatus().getCode().equals("CREATED")) {
            employeeEmployment.setReviewedDate(LocalDateTime.now());
            employeeEmployment.setReviewedUser(authenticatedService.getUser());
            employeeEmployment.setStatus(statusService.getByCode("REVIEWED"));
            stateService.create(employeeEmployment);
            employmentService.review(employeeEmployment.getEmployment().getId());
            return employeeEmployment;
        } else {
            throw new ResourceStateException("The status is not valid is: " + employeeEmployment.getStatus().getName());
        }
    }

    @Override
    public EmployeeEmployment approve(ApprovalWorkflowAwareRequest dto) {
        var employeeEmployment = getById(dto.employeeId(),dto.id());
        if (employeeEmployment.getStatus().getCode().equals("REVIEWED")) {
            employeeEmployment.setApprovedDate(LocalDateTime.now());
            employeeEmployment.setApprovedUser(authenticatedService.getUser());
            employeeEmployment.setStatus(statusService.getByCode("APPROVED"));
            stateService.create(employeeEmployment);
            employmentService.approve(employeeEmployment.getEmployment().getId());
            return employeeEmployment;
        } else {
            throw new ResourceStateException("The status is not valid is: " + employeeEmployment.getStatus().getName());
        }

    }


}
