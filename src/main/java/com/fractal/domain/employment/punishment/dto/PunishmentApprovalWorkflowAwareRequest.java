package com.fractal.domain.employment.punishment.dto;

public record PunishmentApprovalWorkflowAwareRequest(
        Long employmentId,
        Long id
) {
}
