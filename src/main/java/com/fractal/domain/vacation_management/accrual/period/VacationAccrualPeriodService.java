package com.fractal.domain.vacation_management.accrual.period;

import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodRequest;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodResponse;

import java.util.List;

public interface VacationAccrualPeriodService {

    VacationAccrualPeriod create(Long accrualId, VacationAccrualPeriodRequest dto);
    List<VacationAccrualPeriod> getAllByVacationAccrualId(Long accrualId);
    VacationAccrualPeriod getById(Long accrualId , Long id);
    VacationAccrualPeriod getById(Long id);
    VacationAccrualPeriod update(Long accrualId, Long id, VacationAccrualPeriodRequest dto);
    void delete(Long vacationRequestId,Long id);
    VacationAccrualPeriodResponse toDTO(VacationAccrualPeriod period);
    VacationAccrualPeriod save(VacationAccrualPeriod period);

}
