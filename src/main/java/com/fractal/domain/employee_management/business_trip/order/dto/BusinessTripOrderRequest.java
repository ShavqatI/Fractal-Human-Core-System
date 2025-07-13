package com.fractal.domain.employee_management.business_trip.order.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record BusinessTripOrderRequest(
        Long orderTypeId,
        List<MultipartFile> files

) {
}
