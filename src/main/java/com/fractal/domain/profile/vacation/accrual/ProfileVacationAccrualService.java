package com.fractal.domain.profile.vacation.accrual;

import com.fractal.domain.profile.vacation.schedule.ProfileVacationScheduleRequest;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;

import java.util.List;

public interface ProfileVacationAccrualService {
    List<VacationAccrual> getAll();
    VacationAccrualResponse toDTO(VacationAccrual vacationAccrual);


}
