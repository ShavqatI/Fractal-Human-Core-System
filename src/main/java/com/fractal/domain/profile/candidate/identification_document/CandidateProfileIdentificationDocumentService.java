package com.fractal.domain.profile.candidate.identification_document;

import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocument;

import java.util.List;

public interface CandidateProfileIdentificationDocumentService {
    CandidateIdentificationDocument create(IdentificationDocumentRequest dto);
    CandidateIdentificationDocument update(Long id, IdentificationDocumentRequest dto);
    void delete(Long id);
    List<CandidateIdentificationDocument> getAll();
    CandidateIdentificationDocument getById(Long id);
    IdentificationDocumentResponse toDTO(CandidateIdentificationDocument candidateIdentificationDocument);


}
