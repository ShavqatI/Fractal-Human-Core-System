package com.fractal.domain.recruitment.candidate.military_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateMilitaryServiceRepository extends JpaRepository<CandidateMilitaryService, Long> {

    List<CandidateMilitaryService> findAllByCandidateId(Long candidateId);

    Optional<CandidateMilitaryService> findByCandidateIdAndId(Long candidateId, Long id);
}
