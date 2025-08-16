package com.fractal.domain.recruitment.candidate.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateEducationRepository extends JpaRepository<CandidateEducation, Long> {
    List<CandidateEducation> findAllByCandidateId(Long candidateId);
    Optional<CandidateEducation> findByCandidateIdAndId(Long candidateId, Long id);
}
