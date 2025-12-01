package com.fractal.domain.integration.mapping.vacation_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VacationTypeMappingRepository extends JpaRepository<VacationTypeMapping, Long> {

}
