package com.fractal.domain.profile.employee.vacation.accrual;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ProfileVacationAccrualServiceImpl implements ProfileVacationAccrualService {

    private final VacationAccrualService vacationAccrualService;
    private final AuthenticatedService authenticatedService;
    private final StatusService statusService;

    @Override
    public List<VacationAccrual> getAll() {
        return vacationAccrualService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public VacationAccrualResponse toDTO(VacationAccrual vacationAccrual) {
        return vacationAccrualService.toDTO(vacationAccrual);
    }

    @Override
    public List<VacationAccrual> getActive() {
        var vacationAccrual = getAll().getFirst();
        vacationAccrual.setPeriods(filterActivePeriod(vacationAccrual));
        return List.of(vacationAccrual);
    }

    @Override
    public int getAllRemainingPayableDays() {
        return vacationAccrualService.getAllEmployeeRemainingPayableDays(authenticatedService.getEmployeeId());
    }

    @Override
    public int getAllRemainingUnPayableDays() {
        return vacationAccrualService.getAllEmployeeRemainingUnPayableDays(authenticatedService.getEmployeeId());
    }

    @Override
    public int getAllRemainingDays() {
        return vacationAccrualService.getAllEmployeeRemainingDays(authenticatedService.getEmployeeId());
    }

    @Override
    public int getCasualRemainingDays() {
      var record  = getActive().getFirst().getPeriods().getFirst().getRecords().stream().filter(r-> r.getVacationType().getCode().equals("CASUAL")).findFirst();
      return record.get().getRemainingDays();

    }

    private List<VacationAccrualPeriod> filterActivePeriod(VacationAccrual accrual){
       return accrual.getPeriods().stream().filter(period -> statusService.getById(period.getStatus().getId()).getCode().equals("ACTIVE")).collect(Collectors.toList());
    }
}
