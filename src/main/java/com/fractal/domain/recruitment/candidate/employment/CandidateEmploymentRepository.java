package com.fractal.domain.recruitment.candidate.employment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateEmploymentRepository extends JpaRepository<CandidateEmployment, Long> {
    List<CandidateEmployment> findAllByCandidateId(Long candidateId);
    Optional<CandidateEmployment> findByCandidateIdAndId(Long candidateId, Long id);
}
