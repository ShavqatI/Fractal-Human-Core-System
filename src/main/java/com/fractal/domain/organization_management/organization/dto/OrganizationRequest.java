package com.fractal.domain.organization_management.organization.dto;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.work_schedule.dto.WorkScheduleRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record OrganizationRequest(
        @NotBlank
        @Pattern(regexp = "^[A-Z_]{2,50}$", message = "Code must be in Latin uppercase letters")
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
        String tinNumber,
        LocalDate openDate,
        String openReason,
        LocalDate closeDate,
        String closeReason,
        @NotNull
        Long organizationUnitId,
        List<OrganizationAddressRequest> addresses,
        List<ContactRequest> contacts,
        List<WorkScheduleRequest> workSchedules,
        Long statusId,
        List<OrganizationRequest> children

) {
}
