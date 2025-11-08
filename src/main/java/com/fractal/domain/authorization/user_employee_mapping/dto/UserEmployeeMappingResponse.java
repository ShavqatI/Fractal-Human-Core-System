package com.fractal.domain.authorization.user_employee_mapping.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;

import java.time.LocalDateTime;

public record UserEmployeeMappingResponse(
        Long id,
        String username,
        EmployeeCompactResponse employee,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}
