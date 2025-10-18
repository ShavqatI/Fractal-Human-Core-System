package com.fractal.domain.organization_management.grade.method.hay.factor.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface HayFactorTypeRepository extends JpaRepository<HayFactorType,Long> {
    Optional<HayFactorType> findByCode(String code);
}
