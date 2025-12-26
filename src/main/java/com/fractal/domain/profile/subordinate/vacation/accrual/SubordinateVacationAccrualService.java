package com.fractal.domain.profile.subordinate.vacation.accrual;

import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;

import java.util.List;

public interface SubordinateVacationAccrualService {
    List<VacationAccrual> getAll();
    List<VacationAccrual> getAllActivePeriodByEmployeeId(Long employeeId);
    int getAllEmployeeRemainingDays(Long employeeId);
    int getAllEmployeeRemainingDaysForCompensation(Long employeeId);
    int getAllEmployeeRemainingPayableDays(Long employeeId);
    int getAllEmployeeRemainingUnPayableDays(Long employeeId);
    VacationAccrualResponse toDTO(VacationAccrual vacationAccrual);
}

