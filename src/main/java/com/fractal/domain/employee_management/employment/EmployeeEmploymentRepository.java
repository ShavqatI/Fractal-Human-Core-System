package com.fractal.domain.employee_management.employment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeEmploymentRepository extends JpaRepository<EmployeeEmployment, Long> {
    List<EmployeeEmployment> findAllByEmployeeId(Long employeeId);

    Optional<EmployeeEmployment> findByEmployeeIdAndEmploymentId(Long employeeId, Long id);
    Optional<EmployeeEmployment> findByEmployeeIdAndEmploymentEndDateIsNullAndStatusCode(Long employeeId, String statusCode);
    @Query("""
    select ee from EmployeeEmployment ee
    where ee.employee.id = :employeeId
      and ee.employment.startDate <= :date
      and ee.status.code = 'ACTIVE'
    order by ee.employment.startDate desc
    LIMIT 1
""")
    Optional<EmployeeEmployment> findActiveEmploymentBefore(
            Long employeeId,
            LocalDate date
    );
    List<EmployeeEmployment> findAllByEmploymentEndDateIsNullAndEmploymentStatusCode(String statusCode);
}
