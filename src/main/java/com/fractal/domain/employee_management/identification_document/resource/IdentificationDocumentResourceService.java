package com.fractal.domain.employee_management.identification_document.resource;

import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IdentificationDocumentResourceService {

    ResourceResponse toDTO(IdentificationDocumentResource resource);
    IdentificationDocumentResource toEntity(ResourceRequest dto);
    IdentificationDocumentResource toEntity(MultipartFile file,String url);
    IdentificationDocumentResource update(IdentificationDocumentResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    void delete(IdentificationDocumentResource resource);
}
