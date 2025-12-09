package com.fractal.domain.profile.business_trip;

import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseRequest;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record ProfileBusinessTripRequest(
        Long businessTripTypeId,
        Long businessTripPurposeId,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        List<BusinessTripExpenseRequest> expenses,
        List<BusinessTripLocationRequest> locations,
        List<MultipartFile> files
) {
}