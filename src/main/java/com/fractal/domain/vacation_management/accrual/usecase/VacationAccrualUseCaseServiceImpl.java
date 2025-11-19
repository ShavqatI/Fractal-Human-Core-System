package com.fractal.domain.vacation_management.accrual.usecase;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriodService;
import com.fractal.domain.vacation_management.accrual.period.dto.PeriodRequest;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
class VacationAccrualUseCaseServiceImpl implements VacationAccrualUseCaseService {

    private final VacationAccrualService accrualService;
    private final VacationAccrualPeriodService periodService;
    private final VacationAccrualPeriodRecordService periodRecordService;
    @Override
    public Integer getEmployeeAllRemainingDays(Long employeeId, PeriodRequest dto) {
        var accrual = accrualService.getAllByEmployeeId(employeeId)
                .stream()
                .sorted(Comparator.comparing(AbstractEntity::getId))
                .findFirst().get();
        var period = periodService.getByPeriod(accrual.getId(),dto);
        var days = periodRecordService.getAllRemainingDays(period.getId());
        return days;
    }
}
