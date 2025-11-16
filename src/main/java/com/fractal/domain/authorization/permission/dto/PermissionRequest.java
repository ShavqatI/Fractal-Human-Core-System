package com.fractal.domain.authorization.permission.dto;

public record PermissionRequest(
        Long roleId,
        Long menuActionId,
        Long statusId
) {
}
