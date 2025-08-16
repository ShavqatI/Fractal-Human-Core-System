package com.fractal.domain.recruitment.candidate.identification_document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface CandidateIdentificationDocumentRepository extends JpaRepository<CandidateIdentificationDocument, Long> {
    List<CandidateIdentificationDocument> findAllByCandidateId(Long candidateId);
}
