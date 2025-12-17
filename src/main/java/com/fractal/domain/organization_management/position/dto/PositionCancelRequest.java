package com.fractal.domain.organization_management.position.dto;

import jakarta.validation.constraints.NotBlank;

public record PositionCancelRequest(
        @NotBlank
        String reason

) {

}
