package com.fractal.domain.profile.employee.citizenship;

import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;

import java.util.List;

public interface ProfileCitizenshipService {
    List<EmployeeCitizenship> getAll();


    EmployeeCitizenship getById(Long id);

    CitizenshipResponse toDTO(EmployeeCitizenship citizenship);


}
