package com.fractal.domain.employment.separation_reason;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface SeparationReasonRepository extends JpaRepository<SeparationReason, Long> {
    List<SeparationReason> findAllByEmploymentId(Long employmentId);

    Optional<SeparationReason> findByEmploymentIdAndId(Long employmentId, Long id);


}
