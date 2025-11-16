package com.fractal.domain.vacation_management.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface VacationScheduleRepository extends JpaRepository<VacationSchedule,Long> {

    List<VacationSchedule> findAllByEmployeeId(Long employeeId);

}
