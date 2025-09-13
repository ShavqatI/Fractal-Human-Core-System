package com.fractal.domain.employment.work_experience.separation_reason;

import com.fractal.domain.employment.work_experience.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface SeparationReasonRepository extends JpaRepository<SeparationReason,Long> {
    List<SeparationReason> findAllByWorkExperienceId(Long workExperienceId);
    Optional<SeparationReason> findByWorkExperienceIdAndId(Long workExperienceId,Long id);


}
