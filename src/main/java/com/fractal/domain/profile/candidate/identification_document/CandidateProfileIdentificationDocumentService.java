package com.fractal.domain.profile.candidate.identification_document;

import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocument;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;

import java.util.List;

public interface CandidateProfileIdentificationDocumentService {
    List<EmployeeIdentificationDocument> getAll();


    EmployeeIdentificationDocument getById(Long id);

    IdentificationDocumentResponse toDTO(EmployeeIdentificationDocument identificationDocument);


}
