package com.fractal.domain.organization_management.organization.dto;

import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record OrganizationResponse(
        Long id,
        String name,
        String fullName,
        String tinNumber,
        LocalDate openDate,
        String openReason,
        LocalDate closeDate,
        String closeReason,
        String levelMap,
        OrganizationUnitResponse organizationUnit,
        String parent,
        List<OrganizationAddressResponse> addresses,
        List<ContactResponse> contacts,
        List<WorkScheduleResponse> workSchedules,
        List<OrganizationResponse> children,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
