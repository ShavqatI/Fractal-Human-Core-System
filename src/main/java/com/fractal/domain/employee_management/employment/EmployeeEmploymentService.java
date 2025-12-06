package com.fractal.domain.employee_management.employment;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.employee_management.employment.state.ApprovalWorkflowAwareRequest;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.HireRequest;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.TransferRequest;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;
import com.fractal.domain.employment.internal.dto.TerminationRequest;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeEmploymentService extends ApprovalWorkflowAware<ApprovalWorkflowAwareRequest, EmployeeEmployment> {
    EmployeeEmployment create(Long employeeId, EmploymentRequest dto);
    EmployeeEmployment getById(Long employeeId, Long id);
    EmployeeEmployment getById(Long id);
    EmployeeEmployment getActiveEmployment(Long employeeId);
    List<EmployeeEmployment> getAllByEmployeeId(Long employeeId);
    List<EmployeeEmployment> getAllActive();
    EmployeeEmployment getActiveBefore(Long employeeId,LocalDate date);
    List<EmployeeEmployment> getAllApproved();
    EmployeeEmployment update(Long employeeId, Long id, EmploymentRequest dto);
    void delete(Long employeeId, Long id);
    EmployeeEmployment hire(Long employeeId, HireRequest dto);
    EmployeeEmployment terminate(Long employeeId, TerminationRequest dto);
    EmployeeEmployment transfer(Long employeeId, TransferRequest dto);
    EmployeeEmployment activate(Long employeeId,Long id);
    EmploymentResponse toDTO(EmployeeEmployment employment);
    InternalEmploymentApprovedResponse toApprovedDTO(EmployeeEmployment employment);


}
