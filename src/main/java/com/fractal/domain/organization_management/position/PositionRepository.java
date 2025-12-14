package com.fractal.domain.organization_management.position;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface PositionRepository extends JpaRepository<Position, Long> {

    Optional<Position> findByCode(String code);
    Optional<Position> findFirstByOrderByIdDesc();

    @Query("""
    select pos from Position pos
    where 
     pos.supervisory = true
     and pos.status.code = 'ACTIVE'
     and pos.department.id = :departmentId
    """)
    Optional<Position> findActiveSupervisor(Long departmentId);
}
