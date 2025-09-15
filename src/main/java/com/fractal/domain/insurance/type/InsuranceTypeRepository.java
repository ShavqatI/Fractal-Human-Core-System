package com.fractal.domain.insurance.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InsuranceTypeRepository extends JpaRepository<InsuranceType,Long> {
    Optional<InsuranceType> findById(Long id);
    Optional<InsuranceType> findByCode(String code);
    List<InsuranceType> findAll();
}
