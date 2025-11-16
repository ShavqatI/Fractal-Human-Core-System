package com.fractal.domain.vacation_management.vacation.dto;

import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderRequest;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record VacationRequest(
        @NotNull
        Long vacationRequestId,
        List<VacationOrderRequest> orders
) { }