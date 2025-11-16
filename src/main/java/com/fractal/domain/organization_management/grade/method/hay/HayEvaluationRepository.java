package com.fractal.domain.organization_management.grade.method.hay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface HayEvaluationRepository extends JpaRepository<HayEvaluation, Long> {

}
