package com.fractal.domain.vacation_management.accrual.period.record;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacationAccrualPeriodRecordRepository extends JpaRepository<VacationAccrualPeriodRecord,Long> {

    List<VacationAccrualPeriodRecord> findAllByVacationAccrualPeriodId(Long periodId);
    Optional<VacationAccrualPeriodRecord> findByVacationAccrualPeriodIdAndId(Long periodId, Long id);
}
