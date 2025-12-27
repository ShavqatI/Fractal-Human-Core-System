package com.fractal.domain.profile.employee.vacation.accrual;

import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;

import java.util.List;

public interface ProfileVacationAccrualService {
    List<VacationAccrual> getAll();
    VacationAccrualResponse toDTO(VacationAccrual vacationAccrual);
    List<VacationAccrual> getActive();
    int getAllRemainingPayableDays();
    int getAllRemainingUnPayableDays();
    int getAllRemainingDays();
    int getCasualRemainingDays();
}
