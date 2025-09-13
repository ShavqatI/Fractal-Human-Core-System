package com.fractal.domain.employment.work_experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface WorkExperienceRepository extends JpaRepository<WorkExperience,Long> {


}
