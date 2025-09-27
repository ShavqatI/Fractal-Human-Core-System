package com.fractal.domain.employee_management.vacation.order.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record VacationOrderRequest(
        Long orderTypeId,
        List<MultipartFile> files

) {
}
