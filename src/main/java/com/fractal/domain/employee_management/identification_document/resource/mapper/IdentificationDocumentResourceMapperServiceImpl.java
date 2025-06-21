package com.fractal.domain.employee_management.identification_document.resource.mapper;

import com.fractal.domain.employee_management.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class IdentificationDocumentResourceMapperServiceImpl implements IdentificationDocumentResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(Resource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public IdentificationDocumentResource toEntity(ResourceRequest dto) {
        return (IdentificationDocumentResource) mapperService.toEntity(dto);
    }

    @Override
    public IdentificationDocumentResource toEntity(MultipartFile file, String url) {
        return (IdentificationDocumentResource) mapperService.toEntity(file,url);
    }

    @Override
    public IdentificationDocumentResource toEntity(Resource resource, ResourceRequest dto) {
        return (IdentificationDocumentResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
