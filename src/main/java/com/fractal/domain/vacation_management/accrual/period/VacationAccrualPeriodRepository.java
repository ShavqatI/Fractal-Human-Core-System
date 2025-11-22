package com.fractal.domain.vacation_management.accrual.period;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VacationAccrualPeriodRepository extends JpaRepository<VacationAccrualPeriod, Long> {

    List<VacationAccrualPeriod> findAllByVacationAccrualId(Long accrualId);
    List<VacationAccrualPeriod> findAllByVacationAccrualIdAndStatusCodeOrderByStartDateDesc(Long accrualId, String statusCode);
    VacationAccrualPeriod findAllByVacationAccrualIdAndStartDateAndEndDate(Long accrualId, LocalDate startDate,LocalDate endDate);
    Optional<VacationAccrualPeriod> findByVacationAccrualIdAndId(Long accrualId, Long id);
}
