package com.fractal.domain.employee_management.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long> {
}
