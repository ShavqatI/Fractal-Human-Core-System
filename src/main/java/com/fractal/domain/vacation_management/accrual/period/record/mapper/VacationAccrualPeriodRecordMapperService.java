package com.fractal.domain.vacation_management.accrual.period.record.mapper;

import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecord;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordResponse;

public interface VacationAccrualPeriodRecordMapperService {
    VacationAccrualPeriodRecordResponse toDTO(VacationAccrualPeriodRecord record);
    VacationAccrualPeriodRecord toEntity(VacationAccrualPeriodRecordRequest dto);
    VacationAccrualPeriodRecord toEntity(VacationAccrualPeriodRecord record, VacationAccrualPeriodRecordRequest dto);
}


