package com.fractal.domain.recruitment.candidate.identification_document.mapper;

import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocument;


public interface CandidateIdentificationDocumentMapperService {
    IdentificationDocumentResponse toDTO(CandidateIdentificationDocument identificationDocument);
    CandidateIdentificationDocument toEntity(IdentificationDocumentRequest dto);
    CandidateIdentificationDocument toEntity(CandidateIdentificationDocument identificationDocument, IdentificationDocumentRequest dto);
}


