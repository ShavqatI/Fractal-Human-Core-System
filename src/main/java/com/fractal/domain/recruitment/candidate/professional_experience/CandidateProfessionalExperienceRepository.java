package com.fractal.domain.recruitment.candidate.professional_experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CandidateProfessionalExperienceRepository extends JpaRepository<CandidateProfessionalExperience, Long> {

}
