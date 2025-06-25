package com.fractal.domain.organization_management.job_description.qualification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification,Long> {

    List<Qualification> findAllByJobDescriptionId(Long jobDescriptionId);
    Optional<Qualification> findByJobDescriptionIdAndId(Long jobDescriptionId, Long id);
}
