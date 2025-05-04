package com.fractal.domain.organization_management.organization.dto;

import com.fractal.domain.location.address.dto.AddressCreate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record OrganizationCreate (
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
        String parent,
        @NotNull
        @NotBlank
        String organizationUnit,
        List<AddressCreate> addresses
) {
}
