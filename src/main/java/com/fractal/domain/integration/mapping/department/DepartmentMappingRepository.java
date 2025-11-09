package com.fractal.domain.integration.mapping.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DepartmentMappingRepository extends JpaRepository<DepartmentMapping,Long> {

}
