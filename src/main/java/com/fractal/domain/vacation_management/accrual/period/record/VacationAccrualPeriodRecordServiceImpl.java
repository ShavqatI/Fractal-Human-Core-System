package com.fractal.domain.vacation_management.accrual.period.record;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriodService;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordResponse;
import com.fractal.domain.vacation_management.accrual.period.record.mapper.VacationAccrualPeriodRecordMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationAccrualPeriodRecordServiceImpl implements VacationAccrualPeriodRecordService {

    private final VacationAccrualPeriodRecordRepository recordRepository;
    private final VacationAccrualPeriodRecordMapperService mapperService;
    private final VacationAccrualPeriodService accrualPeriodService;
    private final StatusService statusService;


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
    public VacationAccrualPeriodRecord getById(Long id) {
        return recordRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
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

    @Override
    public void decrease(Long id, int days) {
        var record = getById(id);
        record.setRemainingDays(record.getRemainingDays() - days);
        record.setUtilizedDays(days);
        recordRepository.save(record);
        if(record.getRemainingDays().intValue() == 0)
        close(id);
    }

    @Override
    public void increase(Long id, int days) {
        var record = getById(id);
        record.setRemainingDays(record.getRemainingDays() + days);
        record.setUtilizedDays(record.getUtilizedDays() - days);
        recordRepository.save(record);
    }

    @Override
    public void close(Long id) {
        System.out.println("Close coled");
        var record = getById(id);
        record.setStatus(statusService.getByCode("CLOSE"));
        recordRepository.save(record);
    }

}
