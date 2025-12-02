package com.fractal.domain.employee_management.employment.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface EmployeeEmploymentStateRepository extends JpaRepository<EmployeeEmploymentState, Long> {

    List<EmployeeEmploymentState> findAllByEmployeeEmploymentId(Long employeeEmploymentId);

}
