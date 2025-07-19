package com.fractal.domain.employee_management.employment.order.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record EmploymentHistoryOrderRequest(
        Long orderTypeId,
        List<MultipartFile> files

) {
}
