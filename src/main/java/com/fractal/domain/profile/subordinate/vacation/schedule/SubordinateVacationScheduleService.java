package com.fractal.domain.profile.subordinate.vacation.schedule;

import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;

import java.util.List;

public interface SubordinateVacationScheduleService {
    VacationSchedule getById(Long id);
    List<VacationSchedule> getAll();
    VacationSchedule update(Long id, SubordinateVacationScheduleRequest dto);
    VacationScheduleResponse toDTO(VacationSchedule schedule);
    VacationSchedule approve(Long id);

}
