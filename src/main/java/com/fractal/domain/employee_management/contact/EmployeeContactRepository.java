package com.fractal.domain.employee_management.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeContactRepository extends JpaRepository<EmployeeContact,Long> {

}
