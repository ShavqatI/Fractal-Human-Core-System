package com.fractal.domain.organization_management.grade.method.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface GradingEvaluationTypeRepository extends JpaRepository<GradingEvaluationType, Long> {
    Optional<GradingEvaluationType> findByCode(String code);

}
