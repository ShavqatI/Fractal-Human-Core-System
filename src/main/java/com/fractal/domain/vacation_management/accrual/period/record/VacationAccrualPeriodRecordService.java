package com.fractal.domain.vacation_management.accrual.period.record;

import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordResponse;

import java.util.List;

public interface VacationAccrualPeriodRecordService {

    VacationAccrualPeriodRecord create(Long periodId, VacationAccrualPeriodRecordRequest dto);

    List<VacationAccrualPeriodRecord> getAllByVacationAccrualPeriodId(Long periodId);

    VacationAccrualPeriodRecord getById(Long periodId, Long id);

    VacationAccrualPeriodRecord update(Long periodId, Long id, VacationAccrualPeriodRecordRequest dto);

    void delete(Long periodId, Long id);

    VacationAccrualPeriodRecordResponse toDTO(VacationAccrualPeriodRecord record);

}
