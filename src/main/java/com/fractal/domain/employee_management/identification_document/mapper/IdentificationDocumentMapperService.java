package com.fractal.domain.employee_management.identification_document.mapper;

import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.identification_document.IdentificationDocument;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;

public interface IdentificationDocumentMapperService {
    IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument);
    IdentificationDocument toEntity(IdentificationDocumentRequest dto);
    IdentificationDocument toEntity(IdentificationDocument identificationDocument, IdentificationDocumentRequest dto);
}


