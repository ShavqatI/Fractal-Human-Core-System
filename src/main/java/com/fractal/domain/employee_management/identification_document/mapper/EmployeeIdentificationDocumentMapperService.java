package com.fractal.domain.employee_management.identification_document.mapper;

import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocument;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;


public interface EmployeeIdentificationDocumentMapperService {
    IdentificationDocumentResponse toDTO(EmployeeIdentificationDocument identificationDocument);
    EmployeeIdentificationDocument toEntity(IdentificationDocumentRequest dto);
    EmployeeIdentificationDocument toEntity(EmployeeIdentificationDocument identificationDocument, IdentificationDocumentRequest dto);
}


