package com.fractal.domain.order.recognition.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record RecognitionOrderDecreaseSalaryRequest(
        Long orderTypeId,
        String number,
        LocalDate date,
        String sourceDocument,
        Long employeeId,
        BigDecimal salaryAmount,
        LocalDate startDate,
        LocalDate endDate,
        List<MultipartFile> files

) {
}
