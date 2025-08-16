package com.fractal.domain.recruitment.candidate.work_experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateWorkExperienceRepository extends JpaRepository<CandidateWorkExperience, Long> {
    List<CandidateWorkExperience> findAllByCandidateId(Long candidateId);
    Optional<CandidateWorkExperience> findByCandidateIdAndId(Long candidateId, Long id);
}
