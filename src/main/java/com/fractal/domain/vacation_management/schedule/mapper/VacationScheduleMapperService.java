package com.fractal.domain.vacation_management.schedule.mapper;

import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;

public interface VacationScheduleMapperService {
    VacationScheduleResponse toDTO(VacationSchedule vacationSchedule);
    VacationSchedule toEntity(VacationScheduleRequest dto);
    VacationSchedule toEntity(VacationSchedule vacationSchedule, VacationScheduleRequest dto);
}


