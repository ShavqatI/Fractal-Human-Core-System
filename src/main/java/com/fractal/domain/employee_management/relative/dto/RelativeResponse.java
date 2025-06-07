package com.fractal.domain.employee_management.relative.dto;

import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record RelativeResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName,
        LocalDate birthDate,
        String tin,
        String ssn,
        String gender,
        String maritalStatus,
        String nationality,
        String relationType,
        List<RelativeAddressResponse> addresses,
        LocalDateTime createdDate
){

}
