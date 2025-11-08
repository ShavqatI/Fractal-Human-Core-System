package com.fractal.domain.authorization.user_employee_mapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserEmployeeMappingRepository extends JpaRepository<UserEmployeeMapping,Long> { }
