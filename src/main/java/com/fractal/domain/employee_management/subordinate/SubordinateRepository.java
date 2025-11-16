package com.fractal.domain.employee_management.subordinate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SubordinateRepository extends JpaRepository<Subordinate, Long> {

    List<Subordinate> findAllByEmployeeId(Long employeeId);

}
