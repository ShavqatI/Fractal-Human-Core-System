package com.fractal.domain.recruitment.candidate.professional_experience;

import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateProfessionalExperienceRepository extends JpaRepository<CandidateProfessionalExperience, Long> {

    List<CandidateProfessionalExperience> findAllByCandidateId(Long candidateId);
    Optional<CandidateProfessionalExperience> findByCandidateIdAndId(Long candidateId, Long id);
}
