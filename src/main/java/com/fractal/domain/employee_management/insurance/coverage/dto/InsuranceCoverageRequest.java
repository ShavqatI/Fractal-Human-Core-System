package com.fractal.domain.employee_management.insurance.coverage.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record InsuranceCoverageRequest(
         String description,
         BigDecimal amount

) {
}
