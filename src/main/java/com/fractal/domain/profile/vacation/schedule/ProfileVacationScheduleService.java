package com.fractal.domain.profile.vacation.schedule;

import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;

import java.util.List;

public interface ProfileVacationScheduleService {
    VacationSchedule create(ProfileVacationScheduleRequest dto);
    VacationSchedule getById(Long id);
    List<VacationSchedule> getAll();
    VacationSchedule update(Long id, ProfileVacationScheduleRequest dto);
    void deleteById(Long id);
    VacationScheduleResponse toDTO(VacationSchedule schedule);
    VacationSchedule review(Long id);

}
