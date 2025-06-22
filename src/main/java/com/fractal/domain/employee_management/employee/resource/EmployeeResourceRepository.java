package com.fractal.domain.employee_management.employee.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeResourceRepository extends JpaRepository<EmployeeResource,Long> {

    List<EmployeeResource> findAllByEmployeeId(Long employeeId);
    Optional<EmployeeResource> findByEmployeeIdAndId(Long employeeId, Long id);

}
