package com.fractal.domain.employee_management.business_trip.expense.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record BusinessTripExpenseRequest(
        Long businessTripExpenseTypeId,
        Long currencyId,
        BigDecimal amount,
        String description,
        LocalDate date,
        List<MultipartFile> files

) {
}
