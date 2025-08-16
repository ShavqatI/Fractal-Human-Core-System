package com.fractal.domain.education.document_type;

import com.fractal.domain.education.document_type.dto.EducationDocumentTypeRequest;
import com.fractal.domain.education.document_type.dto.EducationDocumentTypeResponse;

import java.util.List;

public interface EducationDocumentTypeService {

    EducationDocumentType create(EducationDocumentTypeRequest dto);
    List<EducationDocumentType> getAll();
    EducationDocumentType getByCode(String code);
    EducationDocumentType getById(Long id);
    EducationDocumentType update(Long id, EducationDocumentTypeRequest dto);
    void deleteById(Long id);
    EducationDocumentTypeResponse toDTO(EducationDocumentType educationDocumentType);
}
