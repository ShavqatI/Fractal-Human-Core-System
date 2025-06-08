package com.fractal.domain.organization_management.organization.dto;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record OrganizationResponse (
        Long id,
        String code,
        String name,
        String fullName,
        String tinNumber,
        LocalDate openDate,
        LocalDate closeDate,
        Integer level,
        String levelMap,
        String organizationUnit,
        String parent,
        List<OrganizationAddressResponse> addresses,
        List<ContactResponse> contacts,
        List<OrganizationResponse> children,
        LocalDateTime createdDate
)
{ }
