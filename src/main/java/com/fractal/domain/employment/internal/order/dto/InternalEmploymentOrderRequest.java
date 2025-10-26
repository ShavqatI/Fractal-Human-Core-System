package com.fractal.domain.employment.internal.order.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record InternalEmploymentOrderRequest(
        Long orderTypeId,
        String number,
        LocalDate date,
        Long statusId,
        List<MultipartFile> files

) {
}
