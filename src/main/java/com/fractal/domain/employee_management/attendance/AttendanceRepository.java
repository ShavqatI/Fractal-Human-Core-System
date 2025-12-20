package com.fractal.domain.employee_management.attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findAllByEmployeeId(Long employeeId);

    @Query("""
        select a from Attendance a
        where a.status.code = 'APPROVED'
        and a.date >= :startDate and a.date <= :endDate
        order by a.date asc 
""")
    List<Attendance> findAllByPeriod(LocalDate startDate, LocalDate endDate);
    @Query("""
        select a from Attendance a
        where a.createdUser.id = :userId 
        order by a.date asc 
""")
    List<Attendance> findAllByUserId(Long userId);

    @Query("""
        select a from Attendance a
        where a.createdUser.id = :userId
        and a.status.id = :statusId  
        order by a.date asc 
""")
    List<Attendance> findAllByUserIdAndStatusId(Long userId, Long statusId);
}
