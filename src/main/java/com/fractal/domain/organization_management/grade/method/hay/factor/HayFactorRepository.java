package com.fractal.domain.organization_management.grade.method.hay.factor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface HayFactorRepository extends JpaRepository<HayFactor,Long> {
   Optional<HayFactor> findByCode(String code);
}
