package com.fractal.domain.recruitment.candidate.identification_document.mapper;

import com.fractal.domain.identification_document.IdentificationDocument;
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
        return convert(new CandidateIdentificationDocument(),mapperService.toEntity(dto));
    }

    @Override
    public CandidateIdentificationDocument toEntity(CandidateIdentificationDocument identificationDocument, IdentificationDocumentRequest dto) {
        return convert(identificationDocument,mapperService.toEntity(identificationDocument,dto));
    }

    private CandidateIdentificationDocument convert(CandidateIdentificationDocument candidateIdentificationDocument, IdentificationDocument identificationDocument) {
        candidateIdentificationDocument.setIdentificationDocumentType(identificationDocument.getIdentificationDocumentType());
        candidateIdentificationDocument.setSeries(identificationDocument.getSeries());
        candidateIdentificationDocument.setNumber(identificationDocument.getNumber());
        candidateIdentificationDocument.setIssueDate(identificationDocument.getIssueDate());
        candidateIdentificationDocument.setExpiryDate(identificationDocument.getExpiryDate());
        candidateIdentificationDocument.setTermInYears(identificationDocument.getTermInYears());
        candidateIdentificationDocument.setIssueOrganization(identificationDocument.getIssueOrganization());
        candidateIdentificationDocument.setIssueOrganizationAddress(identificationDocument.getIssueOrganizationAddress());
        candidateIdentificationDocument.setStatus(identificationDocument.getStatus());
        candidateIdentificationDocument.setResources(identificationDocument.getResources());
        return candidateIdentificationDocument;
    }
}
