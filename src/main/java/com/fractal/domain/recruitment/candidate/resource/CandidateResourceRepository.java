package com.fractal.domain.recruitment.candidate.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateResourceRepository extends JpaRepository<CandidateResource,Long> {
    List<CandidateResource> findAllByCandidateId(Long educationId);
    Optional<CandidateResource> findByCandidateIdAndId(Long educationId, Long id);
}
