package com.fractal.domain.employment.internal.agreement.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record InternalEmploymentAgreementRequest(
        Long agreementTypeId,
        String number,
        LocalDate startDate,
        LocalDate endDate,
        Long statusId,
        List<MultipartFile> files
) {
}
