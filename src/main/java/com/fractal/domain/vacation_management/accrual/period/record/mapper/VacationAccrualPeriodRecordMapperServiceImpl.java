package com.fractal.domain.vacation_management.accrual.period.record.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecord;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordResponse;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class VacationAccrualPeriodRecordMapperServiceImpl implements VacationAccrualPeriodRecordMapperService {
    private final StatusService statusService;
    private final VacationTypeService vacationTypeService;
    @Override
    public VacationAccrualPeriodRecordResponse toDTO(VacationAccrualPeriodRecord record) {
        return new VacationAccrualPeriodRecordResponse(
                record.getId(),
                vacationTypeService.toDTO(record.getVacationType()),
                record.getDate(),
                record.getAccruedDays(),
                record.getUtilizedDays(),
                record.getRemainingDays(),
                statusService.toCompactDTO(record.getStatus()),
                record.getCreatedDate()
        );
    }

    @Override
    public VacationAccrualPeriodRecord toEntity(VacationAccrualPeriodRecordRequest dto) {
        return mapToEntity(new VacationAccrualPeriodRecord(),dto);
    }

    @Override
    public VacationAccrualPeriodRecord toEntity(VacationAccrualPeriodRecord record, VacationAccrualPeriodRecordRequest dto) {
        return mapToEntity(record,dto);
    }

    private VacationAccrualPeriodRecord mapToEntity(VacationAccrualPeriodRecord record, VacationAccrualPeriodRecordRequest dto) {
        record.setVacationType(vacationTypeService.getById(dto.vacationTypeId()));
        record.setDate(dto.date());
        record.setAccruedDays(dto.accruedDays());
        record.setUtilizedDays(dto.utilizedDays());
        record.setRemainingDays(dto.remainingDays());
        record.setStatus(statusService.getById(dto.statusId()));
        return record;
    }

}
