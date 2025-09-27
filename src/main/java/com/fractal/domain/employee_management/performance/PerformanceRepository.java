package com.fractal.domain.employee_management.performance;

import com.fractal.domain.interview.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PerformanceRepository extends JpaRepository<Interview,Long> {

}
