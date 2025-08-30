package com.fractal.domain.organization_management.organization.dto;

import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employment.work_experience.WorkExperience;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;
import com.fractal.domain.work_schedule.WorkSchedule;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;

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
        String openReason,
        LocalDate closeDate,
        String closeReason,
        Integer level,
        String levelMap,
        OrganizationUnitResponse organizationUnit,
        String parent,
        List<OrganizationAddressResponse> addresses,
        List<ContactResponse> contacts,
        List<WorkScheduleResponse> workSchedules,
        List<OrganizationResponse> children,
        LocalDateTime createdDate
)
{ }
