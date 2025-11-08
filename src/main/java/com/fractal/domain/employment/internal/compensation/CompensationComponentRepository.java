package com.fractal.domain.employment.internal.compensation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CompensationComponentRepository extends JpaRepository<CompensationComponent,Long> {

    List<CompensationComponent> findAllByInternalEmploymentId(Long employmentId);
    Optional<CompensationComponent> findByInternalEmploymentIdAndId(Long employmentId, Long id);
}
