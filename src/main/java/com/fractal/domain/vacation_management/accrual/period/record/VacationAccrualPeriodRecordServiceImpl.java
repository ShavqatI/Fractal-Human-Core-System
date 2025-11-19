package com.fractal.domain.vacation_management.accrual.period.record;

import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriodService;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordResponse;
import com.fractal.domain.vacation_management.accrual.period.record.mapper.VacationAccrualPeriodRecordMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class VacationAccrualPeriodRecordServiceImpl implements VacationAccrualPeriodRecordService {

    private final VacationAccrualPeriodRecordRepository recordRepository;
    private final VacationAccrualPeriodRecordMapperService mapperService;
    private final VacationAccrualPeriodService accrualPeriodService;


    @Override
    @Transactional
    public VacationAccrualPeriodRecord create(Long periodId, VacationAccrualPeriodRecordRequest dto) {
        var period = accrualPeriodService.getById(periodId);
        var record = mapperService.toEntity(dto);
        period.addRecord(record);
        accrualPeriodService.save(period);
        return record;
    }

    @Override
    public List<VacationAccrualPeriodRecord> getAllByVacationAccrualPeriodId(Long periodId) {
        return recordRepository.findAllByVacationAccrualPeriodId(periodId);
    }

    @Override
    public VacationAccrualPeriodRecord getById(Long periodId, Long id) {
        return recordRepository.findByVacationAccrualPeriodIdAndId(periodId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public VacationAccrualPeriodRecord update(Long periodId, Long id, VacationAccrualPeriodRecordRequest dto) {
        var period = accrualPeriodService.getById(periodId);
        var record = period.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        record = recordRepository.save(mapperService.toEntity(record, dto));
        accrualPeriodService.save(period);
        return record;
    }

    @Override
    @Transactional
    public void delete(Long periodId, Long id) {
        var period = accrualPeriodService.getById(periodId);
        var record = period.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        period.removeRecord(record);
        accrualPeriodService.save(period);
    }

    @Override
    public VacationAccrualPeriodRecordResponse toDTO(VacationAccrualPeriodRecord record) {
        return mapperService.toDTO(record);
    }

    @Override
    public Integer getAllRemainingDays(Long periodId) {
        return recordRepository.findAllByVacationAccrualPeriodId(periodId)
                .stream()
                .mapToInt(VacationAccrualPeriodRecord::getRemainingDays)
                .sum();
    }


}
