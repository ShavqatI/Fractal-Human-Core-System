package com.fractal.domain.employee_management.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeContactRepository extends JpaRepository<EmployeeContact,Long> {

    List<EmployeeContact> findAllByEmployeeId(Long employeeId);
    Optional<EmployeeContact> findByEmployeeIdAndId(Long employeeId,Long id);
}
