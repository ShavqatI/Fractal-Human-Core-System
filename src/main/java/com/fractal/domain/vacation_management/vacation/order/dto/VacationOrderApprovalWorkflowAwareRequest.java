package com.fractal.domain.vacation_management.vacation.order.dto;

public record VacationOrderApprovalWorkflowAwareRequest(
        Long vacationId,
        Long id
) {
}
