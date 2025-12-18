package com.fractal.domain.profile.employment;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.dto.EmploymentResponse;

import java.util.List;

public interface ProfileEmploymentService {
    List<EmployeeEmployment> getAll();


    EmployeeEmployment getById(Long id);

    EmploymentResponse toDTO(EmployeeEmployment employment);


}
