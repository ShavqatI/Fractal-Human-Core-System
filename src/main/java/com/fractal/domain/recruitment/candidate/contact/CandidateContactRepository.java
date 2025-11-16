package com.fractal.domain.recruitment.candidate.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateContactRepository extends JpaRepository<CandidateContact, Long> {

    List<CandidateContact> findAllByCandidateId(Long employeeId);

    Optional<CandidateContact> findByCandidateIdAndId(Long employeeId, Long id);
}
