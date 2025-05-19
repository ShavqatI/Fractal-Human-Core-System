package com.fractal.domain.employee_management.identification_document.type;

import com.fractal.domain.employee_management.identification_document.type.dto.IdentificationDocumentTypeRequest;
import com.fractal.domain.employee_management.identification_document.type.dto.IdentificationDocumentTypeResponse;

import java.util.List;

public interface IdentificationDocumentTypeService {

    IdentificationDocumentType create(IdentificationDocumentTypeRequest dto);
    List<IdentificationDocumentType> getAll();
    IdentificationDocumentType getByCode(String code);
    IdentificationDocumentType getById(Long id);
    IdentificationDocumentType update(Long id, IdentificationDocumentTypeRequest dto);
    void deleteById(Long id);
    IdentificationDocumentTypeResponse toDTO(IdentificationDocumentType identificationDocumentType);
}
