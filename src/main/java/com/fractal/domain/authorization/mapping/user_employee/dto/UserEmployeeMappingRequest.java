package com.fractal.domain.authorization.mapping.user_employee.dto;

import jakarta.validation.constraints.NotNull;

public record UserEmployeeMappingRequest(
        @NotNull
        Long userId,
        @NotNull
        Long employeeId,
        Long statusId
) {

}
