package com.fractal.domain.agreement.resource.mapper;

import com.fractal.domain.agreement.resource.AgreementResource;
import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AgreementResourceMapperService {
    ResourceResponse toDTO(AgreementResource resource);
    AgreementResource toEntity(ResourceRequest dto);
    AgreementResource toEntity(MultipartFile file, String resourceStoragePath);
    AgreementResource toEntity(AgreementResource resource, MultipartFile file, String resourceStoragePath);
    AgreementResource toEntity(AgreementResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
}


