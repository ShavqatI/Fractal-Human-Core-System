package com.fractal.domain.employee_management.subordinate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface SubordinateRepository extends JpaRepository<Subordinate, Long> {

    List<Subordinate> findAllByEmployeeId(Long employeeId);

    @Query("""
    select s 
    from Subordinate s
    where 
    s.endDate is null
    and s.status.code = 'ACTIVE'
    and s.subordinateEmployee.id = :employeeId
    order by s.startDate desc
    limit 1
   """)
    Optional<Subordinate> findActiveBySubordinateEmployeeId(Long employeeId);
    @Query("""
    select s 
    from Subordinate s
    where 
    s.endDate is null
    and s.status.code = 'ACTIVE'
    and s.employee.id = :employeeId 
    order by s.startDate desc
   """)
    List<Subordinate> findAllActiveSubordinates(Long employeeId);
}
