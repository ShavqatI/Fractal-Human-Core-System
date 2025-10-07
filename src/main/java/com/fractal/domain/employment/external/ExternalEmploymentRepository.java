package com.fractal.domain.employment.external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ExternalEmploymentRepository extends JpaRepository<ExternalEmployment,Long> {

}
