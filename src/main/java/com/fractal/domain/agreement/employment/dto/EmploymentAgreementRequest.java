package com.fractal.domain.agreement.employment.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record EmploymentAgreementRequest(
        Long employmentId,
        Long compensationComponentId,
        Long agreementTypeId,
        String number,
        LocalDate startDate,
        LocalDate endDate,
        List<MultipartFile> files
) {
}
