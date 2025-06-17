package com.fractal.domain.employee_management.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long> {

    List<EmployeeAddress> findAllByEmployeeId(Long employeeId);
}
