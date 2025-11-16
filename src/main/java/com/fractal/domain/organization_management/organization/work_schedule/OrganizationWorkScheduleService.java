package com.fractal.domain.organization_management.organization.work_schedule;

import com.fractal.domain.work_schedule.dto.WorkScheduleRequest;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;

import java.util.List;

public interface OrganizationWorkScheduleService {
    OrganizationWorkSchedule create(Long organizationId, WorkScheduleRequest dto);

    List<OrganizationWorkSchedule> getAllByOrganizationId(Long organizationId);

    OrganizationWorkSchedule getById(Long organizationId, Long id);

    OrganizationWorkSchedule update(Long organizationId, Long id, WorkScheduleRequest dto);

    void delete(Long organizationId, Long id);

    WorkScheduleResponse toDTO(OrganizationWorkSchedule workSchedule);
}
