package com.fractal.domain.profile.employee.military_service;

import com.fractal.domain.employee_management.military_service.EmployeeMilitaryService;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;

import java.util.List;

public interface ProfileMilitaryServiceService {
    List<EmployeeMilitaryService> getAll();


    EmployeeMilitaryService getById(Long id);

    MilitaryServiceResponse toDTO(EmployeeMilitaryService militaryService);


}
