package com.fractal.domain.organization_management.job_description.accountability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountabilityRepository extends JpaRepository<Accountability, Long> {

    List<Accountability> findAllByJobDescriptionId(Long jobDescriptionId);

    Optional<Accountability> findByJobDescriptionIdAndId(Long jobDescriptionId, Long id);
}
