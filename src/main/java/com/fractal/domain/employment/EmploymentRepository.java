package com.fractal.domain.employment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmploymentRepository extends JpaRepository<Employment,Long> {

}
