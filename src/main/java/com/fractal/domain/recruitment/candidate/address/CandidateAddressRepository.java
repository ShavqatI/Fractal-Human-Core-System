package com.fractal.domain.recruitment.candidate.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateAddressRepository extends JpaRepository<CandidateAddress, Long> {
    List<CandidateAddress> findAllByCandidateId(Long candidateId);

    Optional<CandidateAddress> findByCandidateIdAndId(Long candidateId, Long id);
}
