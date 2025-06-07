package com.fractal.domain.employee_management.relative.address.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RelativeAddressResponse(
        Long id,
        String addressType,
        String country,
        String region,
        String city,
        String district,
        String street,
        String house,
        String apartment,
        String postalCode,
        String buildingNumber,
        String floorNumber,
        Double latitude,
        Double longitude,
        LocalDate startDate,
        LocalDate endDate,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
