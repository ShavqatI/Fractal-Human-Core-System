package com.fractal.domain.authorization.mapping.user_employee.dto;

import com.fractal.domain.authorization.user.dto.UserCompactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;

import java.time.LocalDateTime;

public record UserEmployeeMappingResponse(
        Long id,
        UserCompactResponse username,
        EmployeeCompactResponse employee,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}
