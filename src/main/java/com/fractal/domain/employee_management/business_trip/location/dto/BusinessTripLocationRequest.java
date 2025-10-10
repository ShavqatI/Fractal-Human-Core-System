package com.fractal.domain.employee_management.business_trip.location.dto;

import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressRequest;

import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripLocationRequest(
        Long locationTypeId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        List<BusinessTripLocationAddressRequest> addresses,
        Long statusId
) {
}
