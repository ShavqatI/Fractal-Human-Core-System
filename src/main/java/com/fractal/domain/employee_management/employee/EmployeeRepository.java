package com.fractal.domain.employee_management.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    Optional<Employee> findByTin(String tin);

    Optional<Employee> findByUuid(String uuid);
}
