package com.fractal.domain.employee_management.business_trip.expense.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record BusinessTripExpenseRequest(
        Long expenseTypeId,
        LocalDate date,
        Long currencyId,
        BigDecimal amount,
        String description,
        List<MultipartFile> files,
        Long statusId


) {
}
