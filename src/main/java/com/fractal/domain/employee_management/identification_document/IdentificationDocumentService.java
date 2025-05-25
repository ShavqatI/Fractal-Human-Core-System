package com.fractal.domain.employee_management.identification_document;

import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IdentificationDocumentService {
    IdentificationDocument create(IdentificationDocumentRequest dto);
    List<IdentificationDocument> getAll();
    IdentificationDocument getById(Long id);
    IdentificationDocument update(Long id, IdentificationDocumentRequest dto);
    void deleteById(Long id);
    IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument);

    IdentificationDocument addResource(Long id, MultipartFile file);
    IdentificationDocument updateResource(Long id,Long resourceId, MultipartFile file);
    IdentificationDocument deleteResource(Long id,Long resourceId);
}
