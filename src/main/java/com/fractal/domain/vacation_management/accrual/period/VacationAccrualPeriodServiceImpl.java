package com.fractal.domain.vacation_management.accrual.period;

import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import com.fractal.domain.vacation_management.accrual.period.dto.PeriodRequest;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodRequest;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodResponse;
import com.fractal.domain.vacation_management.accrual.period.mapper.VacationAccrualPeriodMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationAccrualPeriodServiceImpl implements VacationAccrualPeriodService {

    private final VacationAccrualPeriodRepository periodRepository;
    private final VacationAccrualPeriodMapperService mapperService;
    private final VacationAccrualService vacationAccrualService;


    @Override
    @Transactional
    public VacationAccrualPeriod create(Long accrualId, VacationAccrualPeriodRequest dto) {
        var accrual = vacationAccrualService.getById(accrualId);
        var period = mapperService.toEntity(dto);
        accrual.addPeriod(period);
        vacationAccrualService.save(accrual);
        return period;
    }

    @Override
    public List<VacationAccrualPeriod> getAllByVacationAccrualId(Long accrualId) {
        return periodRepository.findAllByVacationAccrualId(accrualId);
    }

    @Override
    public VacationAccrualPeriod getById(Long accrualId, Long id) {
        return periodRepository.findByVacationAccrualIdAndId(accrualId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    public VacationAccrualPeriod getById(Long id) {
        return periodRepository.findById(id).orElseThrow(ResourceWithIdNotFoundException::new);
    }

    @Override
    public VacationAccrualPeriod getByPeriod(Long accrualId, PeriodRequest dto) {
        return periodRepository.findAllByVacationAccrualIdAndStartDateAndEndDate(accrualId,dto.startDate(),dto.endDate());
    }

    @Override
    @Transactional
    public VacationAccrualPeriod update(Long accrualId, Long id, VacationAccrualPeriodRequest dto) {
        var accrual = vacationAccrualService.getById(accrualId);
        var period = accrual.getPeriods()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        period = save(mapperService.toEntity(period, dto));
        vacationAccrualService.save(accrual);
        return period;
    }

    @Override
    @Transactional
    public void delete(Long vacationRequestId, Long id) {
        var accrual = vacationAccrualService.getById(vacationRequestId);
        var period = accrual.getPeriods()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        accrual.removePeriod(period);
        vacationAccrualService.save(accrual);
    }

    @Override
    public VacationAccrualPeriodResponse toDTO(VacationAccrualPeriod period) {
        return mapperService.toDTO(period);
    }

    @Override
    @Transactional
    public VacationAccrualPeriod save(VacationAccrualPeriod period) {
        try {
            return periodRepository.save(period);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


}
