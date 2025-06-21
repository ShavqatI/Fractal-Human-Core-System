package com.fractal.domain.employee_management.identification_document.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IdentificationDocumentResourceService {

    IdentificationDocumentResource create(Long identificationDocumentId, MultipartFile file);

    List<IdentificationDocumentResource> getAllByIdentificationDocumentId(Long identificationDocumentId);
    IdentificationDocumentResource getById(Long identificationDocumentId ,Long id);
    IdentificationDocumentResource update(Long identificationDocumentId,Long id, MultipartFile file);
    void delete(Long identificationDocumentId,Long id);
    ResourceResponse toDTO(IdentificationDocumentResource resource);

}
