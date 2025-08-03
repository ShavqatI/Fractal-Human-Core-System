package com.fractal.domain.organization_management.organization.dto;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record OrganizationRequest(
        @NotBlank
        @NotNull
        @Pattern(regexp = "^[A-Z]{2,20}$", message = "Code must be in Latin uppercase letters")
        String code,
        @NotBlank
        @NotNull
        @Size(min = 3, max = 100, message = "The name length should be in (3 to 100 symbols)")
        @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$",message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
        String name,
        @NotBlank
        @Size(min = 3, max = 100, message = "The name length should be in (3 to 100 symbols)")
        @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$",message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
        @NotNull
        String fullName,
        @NotNull
        @NotBlank
        String tinNumber,
        @NotNull
        LocalDate openDate,
        LocalDate closeDate,
        @NotNull
        Integer level,
        @NotBlank
        @NotNull
        String levelMap,
        @NotNull
        @NotBlank
        String organizationUnit,
        List<OrganizationAddressRequest> addresses,
        List<ContactRequest> contacts,
        List<OrganizationRequest> children

) {
}
