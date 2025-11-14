package com.fractal.domain.authorization.mapping.user_employee;

import com.fractal.domain.authorization.mapping.user_employee.dto.UserEmployeeMappingRequest;
import com.fractal.domain.authorization.mapping.user_employee.dto.UserEmployeeMappingResponse;

import java.util.List;

public interface UserEmployeeMappingService {

    UserEmployeeMapping create(UserEmployeeMappingRequest dto);
    List<UserEmployeeMapping> getAll();
    UserEmployeeMapping getById(Long id);
    UserEmployeeMapping update(Long id, UserEmployeeMappingRequest dto);
    void deleteById(Long id);
    UserEmployeeMappingResponse toDTO(UserEmployeeMapping userEmployeeMapping);
}
