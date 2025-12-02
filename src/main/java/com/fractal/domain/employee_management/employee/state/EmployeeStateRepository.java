package com.fractal.domain.employee_management.employee.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface EmployeeStateRepository extends JpaRepository<EmployeeState, Long> {

    List<EmployeeState> findAllByEmployeeId(Long employeeId);

}
