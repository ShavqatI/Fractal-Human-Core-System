package com.fractal.domain.authorization.user_employee_mapping.dto;

import jakarta.validation.constraints.NotNull;

public record UserEmployeeMappingRequest(
        @NotNull
        Long userId,
        @NotNull
        Long employeeId,
        Long statusId
) {

}
