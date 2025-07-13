package com.fractal.domain.employee_management.business_trip.dto;

import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record BusinessTripRequest(
        Long employeeId,
        Long organizationId,
        Long businessTripTypeId,
        Long statusId,
        String purpose,
        String description,
        String location,
        LocalDate startDate,
        LocalDate endDate,
        Integer days,
        List<BusinessTripOrderRequest> orders,
        List<MultipartFile> files
) { }