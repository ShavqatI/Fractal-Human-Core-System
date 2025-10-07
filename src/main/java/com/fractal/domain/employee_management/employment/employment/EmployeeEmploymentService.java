package com.fractal.domain.employee_management.employment.employment;

import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.external.dto.ExternalEmploymentResponse;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;

import java.util.List;

public interface EmployeeEmploymentService {

    /*EmployeeEmployment create(Long employeeId, EmploymentRequest dto);
    EmployeeEmployment getById(Long employeeId, Long id);
    List<EmployeeEmployment> getAllByEmployeeId(Long employeeId);
    EmployeeEmployment update(Long employeeId, Long id, EmploymentRequest dto);
    void delete(Long employeeId, Long id);
    EmploymentResponse toDTO(EmployeeEmployment employment);*/

    EmployeeEmployment create(Long employeeId, InternalEmploymentRequest dto);
    EmployeeEmployment create(Long employeeId, ExternalEmploymentRequest dto);
    EmployeeEmployment update(Long employeeId, Long id, InternalEmploymentRequest dto);
    EmployeeEmployment update(Long employeeId, Long id, ExternalEmploymentRequest dto);
    void delete(Long employeeId, Long id);
    EmploymentResponse toDTO(EmployeeEmployment employment);
}
