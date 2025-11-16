package com.fractal.domain.organization_management.job_description.required_experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequiredExperienceRepository extends JpaRepository<RequiredExperience, Long> {

    List<RequiredExperience> findAllByJobDescriptionId(Long jobDescriptionId);

    Optional<RequiredExperience> findByJobDescriptionIdAndId(Long jobDescriptionId, Long id);
}
