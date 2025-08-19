package com.fractal.domain.employee_management.military_service;


import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;

import java.util.List;


public interface EmployeeMilitaryServiceService {

    EmployeeMilitaryService create(Long employeeId, MilitaryServiceRequest dto);
    List<EmployeeMilitaryService> getAllByEmployeeId(Long employeeId);
    EmployeeMilitaryService getById(Long employeeId , Long id);
    EmployeeMilitaryService getById(Long id);
    MilitaryServiceResponse toDTO(EmployeeMilitaryService employeeMilitaryService);
    EmployeeMilitaryService update(Long employeeId, Long id, MilitaryServiceRequest dto);
    void delete(Long employeeId,Long id);
    EmployeeMilitaryService save(EmployeeMilitaryService employeeMilitaryService);

}
