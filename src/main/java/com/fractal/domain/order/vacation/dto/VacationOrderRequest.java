package com.fractal.domain.order.vacation.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record VacationOrderRequest(
        Long orderTypeId,
        Long vacationId,
        String number,
        LocalDate date,
        Long statusId,
        List<MultipartFile> files
) {
}
