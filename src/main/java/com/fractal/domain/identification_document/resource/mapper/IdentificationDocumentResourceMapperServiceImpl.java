package com.fractal.domain.identification_document.resource.mapper;

import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class IdentificationDocumentResourceMapperServiceImpl implements IdentificationDocumentResourceMapperService {

    private final ResourceMapperService resourceMapperService;

    @Override
    public ResourceResponse toDTO(IdentificationDocumentResource resource) {
        return resourceMapperService.toDTO(resource);
    }

    @Override
    public IdentificationDocumentResource toEntity(ResourceRequest dto) {
        return (IdentificationDocumentResource) resourceMapperService.toEntity(dto);
    }

    @Override
    public IdentificationDocumentResource toEntity(MultipartFile file, String url) {
        return (IdentificationDocumentResource) resourceMapperService.toEntity(file,url);
    }

    @Override
    public IdentificationDocumentResource toEntity(IdentificationDocumentResource resource, ResourceRequest dto) {
        return (IdentificationDocumentResource) resourceMapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceMapperService.fileToRequest(file,url);
    }
}
