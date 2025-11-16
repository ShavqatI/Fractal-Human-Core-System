package com.fractal.domain.military_service.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record MilitaryServiceRequest(
        String accountNumber,
        String title,
        String categoryFund,
        String address,
        LocalDate beginDate,
        LocalDate endDate,
        List<MultipartFile> files
) {
}
