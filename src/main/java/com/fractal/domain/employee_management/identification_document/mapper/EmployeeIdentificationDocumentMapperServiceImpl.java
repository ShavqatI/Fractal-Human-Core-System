package com.fractal.domain.employee_management.identification_document.mapper;

import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocument;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.identification_document.mapper.IdentificationDocumentMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeIdentificationDocumentMapperServiceImpl implements EmployeeIdentificationDocumentMapperService {

    private final IdentificationDocumentMapperService mapperService;

    @Override
    public IdentificationDocumentResponse toDTO(EmployeeIdentificationDocument identificationDocument) {
        return mapperService.toDTO(identificationDocument);
    }

    @Override
    public EmployeeIdentificationDocument toEntity(IdentificationDocumentRequest dto) {
        return (EmployeeIdentificationDocument) mapperService.toEntity(dto);
    }

    @Override
    public EmployeeIdentificationDocument toEntity(EmployeeIdentificationDocument identificationDocument, IdentificationDocumentRequest dto) {
        return (EmployeeIdentificationDocument) mapperService.toEntity(identificationDocument,dto);
    }
}
