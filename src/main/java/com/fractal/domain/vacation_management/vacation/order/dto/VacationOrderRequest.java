package com.fractal.domain.vacation_management.vacation.order.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record VacationOrderRequest(
        Long orderTypeId,
        String number,
        LocalDate date,
        Long statusId,
        List<MultipartFile> files
) {
}
