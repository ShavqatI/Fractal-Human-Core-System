package com.fractal.domain.recruitment.candidate.identification_document.mapper;

import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.identification_document.mapper.IdentificationDocumentMapperService;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateIdentificationDocumentMapperServiceImpl implements CandidateIdentificationDocumentMapperService {

    private final IdentificationDocumentMapperService mapperService;

    @Override
    public IdentificationDocumentResponse toDTO(CandidateIdentificationDocument identificationDocument) {
        return mapperService.toDTO(identificationDocument);
    }

    @Override
    public CandidateIdentificationDocument toEntity(IdentificationDocumentRequest dto) {
        return (CandidateIdentificationDocument) mapperService.toEntity(dto);
    }

    @Override
    public CandidateIdentificationDocument toEntity(CandidateIdentificationDocument identificationDocument, IdentificationDocumentRequest dto) {
        return (CandidateIdentificationDocument) mapperService.toEntity(identificationDocument,dto);
    }
}
