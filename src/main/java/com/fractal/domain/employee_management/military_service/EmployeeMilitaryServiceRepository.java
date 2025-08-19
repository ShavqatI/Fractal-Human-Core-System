package com.fractal.domain.employee_management.military_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeMilitaryServiceRepository extends JpaRepository<EmployeeMilitaryService,Long> {

    List<EmployeeMilitaryService> findAllByEmployeeId(Long employeeId);
    Optional<EmployeeMilitaryService> findByEmployeeIdAndId(Long employeeId, Long id);
}
