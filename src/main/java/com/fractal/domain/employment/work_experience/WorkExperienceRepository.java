package com.fractal.domain.employment.work_experience;

import com.fractal.domain.employment.work_experience.separation_reason.SeparationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface WorkExperienceRepository extends JpaRepository<WorkExperience,Long> {


}
