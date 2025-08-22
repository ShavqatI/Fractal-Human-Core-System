package com.fractal.domain.recruitment.candidate.resource.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateResourceTypeRepository extends JpaRepository<CandidateResourceType,Long> {

    CandidateResourceType save(CandidateResourceType candidateResourceType);
    List<CandidateResourceType> findAll();
    Optional<CandidateResourceType> findByCode(String code);
    Optional<CandidateResourceType> findById(Long id);

}
