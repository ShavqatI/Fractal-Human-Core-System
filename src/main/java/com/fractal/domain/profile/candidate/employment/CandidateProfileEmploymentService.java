package com.fractal.domain.profile.candidate.employment;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.dto.EmploymentResponse;

import java.util.List;

public interface CandidateProfileEmploymentService {
    List<EmployeeEmployment> getAll();

    EmployeeEmployment getById(Long id);
    EmploymentResponse toDTO(EmployeeEmployment employment);


}
