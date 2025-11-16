package com.fractal.domain.identification_document.resource.mapper;

import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IdentificationDocumentResourceMapperService {
    ResourceResponse toDTO(IdentificationDocumentResource resource);

    IdentificationDocumentResource copy(IdentificationDocumentResource resource);

    IdentificationDocumentResource toEntity(ResourceRequest dto);

    IdentificationDocumentResource toEntity(MultipartFile file, String resourceStoragePath);

    IdentificationDocumentResource toEntity(IdentificationDocumentResource resource, MultipartFile file, String resourceStoragePath);

    IdentificationDocumentResource toEntity(IdentificationDocumentResource resource, ResourceRequest dto);

    ResourceRequest fileToRequest(MultipartFile file, String url);
}


