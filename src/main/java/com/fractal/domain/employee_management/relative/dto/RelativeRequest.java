package com.fractal.domain.employee_management.relative.dto;

import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;

import java.time.LocalDate;
import java.util.List;

public record RelativeRequest(
        String lastName,
        String firstName,
        String patronymicName,
        LocalDate birthDate,
        String tin,
        String ssn,
        Long genderId,
        Long maritalStatusId,
        Long nationalityId,
        Long relationTypeId,
        List<RelativeAddressRequest> addresses

){

}
