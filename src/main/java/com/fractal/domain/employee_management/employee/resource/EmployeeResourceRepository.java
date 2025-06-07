package com.fractal.domain.employee_management.employee.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeResourceRepository extends JpaRepository<EmployeeResource,Long> {

}
