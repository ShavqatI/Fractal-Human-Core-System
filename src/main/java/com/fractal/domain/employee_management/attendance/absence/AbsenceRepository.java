package com.fractal.domain.employee_management.attendance.absence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findAllByEmployeeId(Long employeeId);

}
