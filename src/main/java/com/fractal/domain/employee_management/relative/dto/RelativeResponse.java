package com.fractal.domain.employee_management.relative.dto;

import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusResponse;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;
import com.fractal.domain.employee_management.relative.type.dto.RelationTypeResponse;

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
        GenderResponse gender,
        MaritalStatusResponse maritalStatus,
        NationalityResponse nationality,
        RelationTypeResponse relationType,
        List<RelativeAddressResponse> addresses,
        List<ContactResponse> contacts,
        LocalDateTime createdDate
) {

}
