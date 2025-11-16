package com.fractal.domain.vacation_management.accrual.period.mapper;

import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodRequest;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodResponse;

public interface VacationAccrualPeriodMapperService {
    VacationAccrualPeriodResponse toDTO(VacationAccrualPeriod period);
    VacationAccrualPeriod toEntity(VacationAccrualPeriodRequest dto);
    VacationAccrualPeriod toEntity(VacationAccrualPeriod period, VacationAccrualPeriodRequest dto);
}


