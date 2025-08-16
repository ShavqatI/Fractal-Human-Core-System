package com.fractal.domain.recruitment.candidate.identification_document;

import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.identification_document.mapper.CandidateIdentificationDocumentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateIdentificationDocumentServiceImpl implements CandidateIdentificationDocumentService {

    private final CandidateService candidateService;
    private final CandidateIdentificationDocumentRepository candidateIdentificationDocumentRepository;
    private final CandidateIdentificationDocumentMapperService candidateIdentificationDocumentMapperService;


    @Override
    @Transactional
    public CandidateIdentificationDocument create(Long employeeId, IdentificationDocumentRequest dto) {
        var candidate = candidateService.getById(employeeId);
        var identificationDocument = candidateIdentificationDocumentMapperService.toEntity(dto);
        candidate.addIdentificationDocument(identificationDocument);
        candidateService.save(candidate);
        return identificationDocument;
    }

    @Override
    public List<CandidateIdentificationDocument> getAllByEmployeeId(Long employeeId) {
        return candidateIdentificationDocumentRepository.findAllByCandidateId(employeeId);
    }

    @Override
    public CandidateIdentificationDocument getById(Long employeeId , Long id) {
        var candidate = candidateService.getById(employeeId);
        return candidate.getIdentificationDocuments()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));

    }

    @Override
    public CandidateIdentificationDocument getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public CandidateIdentificationDocument update(Long employeeId, Long id, IdentificationDocumentRequest dto) {
        var candidate = candidateService.getById(employeeId);
        var identificationDocument = candidate.getIdentificationDocuments()
                .stream()
                .filter(i-> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));
        identificationDocument = candidateIdentificationDocumentRepository.save(candidateIdentificationDocumentMapperService.toEntity(identificationDocument,dto));
        candidateService.save(candidate);
        return identificationDocument;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = candidateService.getById(employeeId);
        var identificationDocument = employee.getIdentificationDocuments()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));
        employee.removeIdentificationDocument(identificationDocument);
        candidateService.save(employee);
    }

    @Override
    public IdentificationDocumentResponse toDTO(CandidateIdentificationDocument candidateIdentificationDocument) {
        return candidateIdentificationDocumentMapperService.toDTO(candidateIdentificationDocument);
    }

    private CandidateIdentificationDocument findById(Long id) {
        return candidateIdentificationDocumentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Identification Document with id: " + id + " not found"));
    }
}
