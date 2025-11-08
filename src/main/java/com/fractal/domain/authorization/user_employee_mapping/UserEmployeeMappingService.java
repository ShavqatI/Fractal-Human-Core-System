package com.fractal.domain.authorization.user_employee_mapping;

import com.fractal.domain.authorization.user_employee_mapping.dto.UserEmployeeMappingRequest;
import com.fractal.domain.authorization.user_employee_mapping.dto.UserEmployeeMappingResponse;

import java.util.List;

public interface UserEmployeeMappingService {

    UserEmployeeMapping create(UserEmployeeMappingRequest dto);
    List<UserEmployeeMapping> getAll();
    UserEmployeeMapping getById(Long id);
    UserEmployeeMapping update(Long id, UserEmployeeMappingRequest dto);
    void deleteById(Long id);
    UserEmployeeMappingResponse toDTO(UserEmployeeMapping userEmployeeMapping);
}
