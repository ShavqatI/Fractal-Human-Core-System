package com.fractal.domain.organization_management.organization.work_schedule.mapper;

import com.fractal.domain.organization_management.organization.work_schedule.OrganizationWorkSchedule;
import com.fractal.domain.work_schedule.dto.WorkScheduleRequest;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;

public interface OrganizationWorkScheduleMapperService {
    WorkScheduleResponse toDTO(OrganizationWorkSchedule workSchedule);
    OrganizationWorkSchedule toEntity(WorkScheduleRequest dto);
    OrganizationWorkSchedule toEntity(OrganizationWorkSchedule contact, WorkScheduleRequest dto);
}


