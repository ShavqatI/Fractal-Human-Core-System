package com.fractal.domain.employee_management.insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    List<Insurance> findAllByEmployeeId(Long employeeId);
}
