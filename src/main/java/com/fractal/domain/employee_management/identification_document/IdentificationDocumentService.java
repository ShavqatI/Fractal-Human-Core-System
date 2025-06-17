package com.fractal.domain.employee_management.identification_document;

import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IdentificationDocumentService {

    IdentificationDocument create(Long employeeId, IdentificationDocumentRequest dto);
    IdentificationDocument update(Long employeeId,Long id, IdentificationDocumentRequest dto);
    void delete(Long employeeId,Long id);
    List<IdentificationDocument> getAllByEmployeeId(Long employeeId);
    IdentificationDocument getById(Long employeeId ,Long id);
    IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument);
    IdentificationDocument toEntity(IdentificationDocumentRequest dto);
    IdentificationDocument addResource(Long id, MultipartFile file);
    IdentificationDocument updateResource(Long id,Long resourceId, MultipartFile file);
    IdentificationDocument deleteResource(Long id,Long resourceId);
}
