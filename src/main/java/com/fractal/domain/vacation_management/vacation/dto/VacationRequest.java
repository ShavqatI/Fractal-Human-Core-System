package com.fractal.domain.vacation_management.vacation.dto;

import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record VacationRequest(
        @NotNull
        Long vacationRequestId,
        BigDecimal compensationPercentage,
        BigDecimal successorCompensationPercentage
) { }