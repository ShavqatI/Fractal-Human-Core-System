package com.fractal.domain.organization_management.job_description.required_experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequiredExperienceRepository extends JpaRepository<RequiredExperience,Long> {
}
