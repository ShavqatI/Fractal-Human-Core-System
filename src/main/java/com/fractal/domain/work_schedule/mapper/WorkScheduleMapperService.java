package com.fractal.domain.work_schedule.mapper;

import com.fractal.domain.work_schedule.WorkSchedule;
import com.fractal.domain.work_schedule.dto.WorkScheduleRequest;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;

public interface WorkScheduleMapperService {
    WorkScheduleResponse toDTO(WorkSchedule workSchedule);
    WorkSchedule toEntity(WorkScheduleRequest dto);
    WorkSchedule toEntity(WorkSchedule workSchedule, WorkScheduleRequest dto);
}


