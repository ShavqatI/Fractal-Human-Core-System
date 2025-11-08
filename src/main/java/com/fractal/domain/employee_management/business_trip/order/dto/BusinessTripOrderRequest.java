package com.fractal.domain.employee_management.business_trip.order.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record BusinessTripOrderRequest(
        Long orderTypeId,
        String number,
        LocalDate date,
        Long statusId,
        List<MultipartFile> files

) {
}
