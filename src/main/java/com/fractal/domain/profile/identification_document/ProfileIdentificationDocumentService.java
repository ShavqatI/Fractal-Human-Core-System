package com.fractal.domain.profile.identification_document;

import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocument;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;

import java.util.List;

public interface ProfileIdentificationDocumentService {
    List<EmployeeIdentificationDocument> getAll();


    EmployeeIdentificationDocument getById(Long id);

    IdentificationDocumentResponse toDTO(EmployeeIdentificationDocument identificationDocument);


}
