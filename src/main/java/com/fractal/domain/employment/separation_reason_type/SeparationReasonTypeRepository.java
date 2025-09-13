package com.fractal.domain.employment.separation_reason_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SeparationReasonTypeRepository extends JpaRepository<SeparationReasonType,Long> {

    Optional<SeparationReasonType> findByCode(String code);

}
