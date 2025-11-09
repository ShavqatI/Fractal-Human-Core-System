package com.fractal.domain.integration.mapping.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmployeeMappingRepository extends JpaRepository<EmployeeMapping,Long> {

}
