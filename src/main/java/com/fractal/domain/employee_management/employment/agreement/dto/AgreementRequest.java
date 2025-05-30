package com.fractal.domain.employee_management.employment.agreement.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record AgreementRequest(
        String number,
        LocalDate startDate,
        LocalDate endDate,
        Long statusId,
        List<MultipartFile> files
) {
}
