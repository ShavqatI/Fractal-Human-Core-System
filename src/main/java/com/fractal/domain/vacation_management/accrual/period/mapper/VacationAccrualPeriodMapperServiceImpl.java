package com.fractal.domain.vacation_management.accrual.period.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodRequest;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodResponse;
import com.fractal.domain.vacation_management.accrual.period.record.mapper.VacationAccrualPeriodRecordMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class VacationAccrualPeriodMapperServiceImpl implements VacationAccrualPeriodMapperService {
    private final StatusService statusService;
    private final VacationAccrualPeriodRecordMapperService recordMapperService;

    @Override
    public VacationAccrualPeriodResponse toDTO(VacationAccrualPeriod period) {
        return new VacationAccrualPeriodResponse(
                period.getId(),
                period.getStartDate(),
                period.getEndDate(),
                Optional.ofNullable(period.getRecords())
                        .orElse(emptyList())
                        .stream()
                        .map(recordMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(period.getStatus()),
                period.getCreatedDate()
        );
    }

    @Override
    public VacationAccrualPeriod toEntity(VacationAccrualPeriodRequest dto) {
        return mapToEntity(new VacationAccrualPeriod(), dto);
    }

    @Override
    public VacationAccrualPeriod toEntity(VacationAccrualPeriod period, VacationAccrualPeriodRequest dto) {
        return mapToEntity(period, dto);
    }

    private VacationAccrualPeriod mapToEntity(VacationAccrualPeriod period, VacationAccrualPeriodRequest dto) {
        period.setStartDate(dto.startDate());
        period.setEndDate(dto.endDate());
        period.setStatus(statusService.getByCode("ACTIVE"));
        dto.records().forEach(record -> period.addRecord(recordMapperService.toEntity(record)));
        return period;
    }

}
