package com.fractal.domain.employee_management.employment;

import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;

import java.util.List;

public interface EmployeeEmploymentService {
    EmployeeEmployment create(Long employeeId, EmploymentRequest dto);

    EmployeeEmployment getById(Long employeeId, Long id);
    EmployeeEmployment getById(Long id);

    List<EmployeeEmployment> getAllByEmployeeId(Long employeeId);

    List<EmployeeEmployment> getAllActive();
    List<EmployeeEmployment> getAllApproved();

    EmployeeEmployment update(Long employeeId, Long id, EmploymentRequest dto);

    void delete(Long employeeId, Long id);

    EmploymentResponse toDTO(EmployeeEmployment employment);
    InternalEmploymentApprovedResponse toApprovedDTO(EmployeeEmployment employment);

}
