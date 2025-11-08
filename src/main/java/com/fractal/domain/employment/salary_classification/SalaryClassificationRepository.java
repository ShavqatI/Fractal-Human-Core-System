package com.fractal.domain.employment.salary_classification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SalaryClassificationRepository extends JpaRepository<SalaryClassification,Long> {

    Optional<SalaryClassification> findByCode(String code);

}
