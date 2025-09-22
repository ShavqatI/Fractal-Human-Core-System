package com.fractal.domain.training_management.training.expense.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TrainingExpenseRequest(
        Long expenseTypeId,
        LocalDate date,
        Long currencyId,
        BigDecimal amount,

        String description,

        String invoiceNumber,
        List<MultipartFile> files,
        Long statusId
) { }
