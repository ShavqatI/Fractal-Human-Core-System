package com.fractal.domain.employee_management.attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    List<Attendance> findAllByEmployeeId(Long employeeId);

}
