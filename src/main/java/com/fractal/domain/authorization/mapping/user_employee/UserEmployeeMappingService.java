package com.fractal.domain.authorization.mapping.user_employee;

import com.fractal.domain.authorization.mapping.user_employee.dto.UserEmployeeMappingRequest;
import com.fractal.domain.authorization.mapping.user_employee.dto.UserEmployeeMappingResponse;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.employee_management.employee.Employee;

import java.util.List;

public interface UserEmployeeMappingService {

    UserEmployeeMapping create(UserEmployeeMappingRequest dto);

    List<UserEmployeeMapping> getAll();

    UserEmployeeMapping getById(Long id);
    UserEmployeeMapping getByUserId(Long userId);
    Employee getEmployee(User user);

    UserEmployeeMapping update(Long id, UserEmployeeMappingRequest dto);

    void deleteById(Long id);

    UserEmployeeMappingResponse toDTO(UserEmployeeMapping userEmployeeMapping);
}
