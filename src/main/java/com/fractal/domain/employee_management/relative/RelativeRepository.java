package com.fractal.domain.employee_management.relative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface RelativeRepository extends JpaRepository<Relative,Long> {
    List<Relative> findAllByEmployeeId(Long employeeId);
    Optional<Relative> findByEmployeeIdAndId(Long employeeId, Long id);
}
