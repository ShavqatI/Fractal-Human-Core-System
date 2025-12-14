package com.fractal.domain.employee_management.business_trip.dto;

import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseRequest;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record BusinessTripProlongRequest(
        String description,
        LocalDate startDate,
        LocalDate endDate
) {
}