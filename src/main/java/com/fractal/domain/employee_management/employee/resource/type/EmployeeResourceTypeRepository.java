package com.fractal.domain.employee_management.employee.resource.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeResourceTypeRepository extends JpaRepository<EmployeeResourceType,Long> {

    EmployeeResourceType save(EmployeeResourceType employeeResourceType);
    List<EmployeeResourceType> findAll();
    Optional<EmployeeResourceType> findByCode(String code);
    Optional<EmployeeResourceType> findById(Long id);

}
