package com.fractal.domain.recruitment.candidate.identification_document;

import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;

import java.util.List;

public interface CandidateIdentificationDocumentService {

    CandidateIdentificationDocument create(Long candidateId, IdentificationDocumentRequest dto);

    CandidateIdentificationDocument update(Long candidateId, Long id, IdentificationDocumentRequest dto);

    void delete(Long employeeId, Long id);

    List<CandidateIdentificationDocument> getAllByCandidateId(Long candidateId);

    CandidateIdentificationDocument getById(Long candidateId, Long id);

    CandidateIdentificationDocument getById(Long id);

    IdentificationDocumentResponse toDTO(CandidateIdentificationDocument candidateIdentificationDocument);


}
