package com.fractal.domain.profile.vacation.accrual;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.profile.vacation.schedule.ProfileVacationScheduleRequest;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.VacationScheduleService;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileVacationAccrualServiceImpl implements ProfileVacationAccrualService {

    private final VacationAccrualService vacationAccrualService;
    private final AuthenticatedService authenticatedService;

    @Override
    public List<VacationAccrual> getAll() {
        return vacationAccrualService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public VacationAccrualResponse toDTO(VacationAccrual vacationAccrual) {
        return vacationAccrualService.toDTO(vacationAccrual);
    }
}
