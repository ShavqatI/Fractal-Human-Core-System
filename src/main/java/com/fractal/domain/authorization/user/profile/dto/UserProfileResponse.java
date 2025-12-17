package com.fractal.domain.authorization.user.profile.dto;

import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;

import java.time.LocalDateTime;

public record UserProfileResponse(

        String username,
        EmployeeCompactResponse employee,
        String photo,
        LocalDateTime createdDate
) {}
