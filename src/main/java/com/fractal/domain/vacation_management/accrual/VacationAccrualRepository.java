package com.fractal.domain.vacation_management.accrual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface VacationAccrualRepository extends JpaRepository<VacationAccrual,Long> {

    List<VacationAccrual> findAllByEmployeeId(Long employeeId);

}
