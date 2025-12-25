package com.fractal.domain.profile.candidate.identification_document;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocument;
import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocumentService;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.recruitment.candidate.employment.CandidateEmployment;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocument;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocumentService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileIdentificationDocumentServiceImpl implements CandidateProfileIdentificationDocumentService {

   private final CandidateIdentificationDocumentService identificationDocumentService;
   private final AuthenticatedService authenticatedService;


    @Override
    public CandidateIdentificationDocument create(IdentificationDocumentRequest dto) {
        return identificationDocumentService.create(authenticatedService.getCandidateId(), dto);
    }

    @Override
    public CandidateIdentificationDocument update(Long id, IdentificationDocumentRequest dto) {
        return identificationDocumentService.update(authenticatedService.getCandidateId(), findById(id).getId(),dto);
    }

    @Override
    public void delete(Long id) {
      identificationDocumentService.delete(authenticatedService.getCandidateId(), id);
    }

    @Override
    public List<CandidateIdentificationDocument> getAll() {
        return identificationDocumentService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateIdentificationDocument getById(Long id) {
        return findById(id);
    }

    @Override
    public IdentificationDocumentResponse toDTO(CandidateIdentificationDocument candidateIdentificationDocument) {
        return identificationDocumentService.toDTO(candidateIdentificationDocument);
    }

    private CandidateIdentificationDocument findById(Long id) {
        return identificationDocumentService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
