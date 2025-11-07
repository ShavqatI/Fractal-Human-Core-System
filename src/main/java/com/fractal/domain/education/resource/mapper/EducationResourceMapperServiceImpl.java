package com.fractal.domain.education.resource.mapper;

import com.fractal.domain.education.resource.EducationResource;
import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class EducationResourceMapperServiceImpl implements EducationResourceMapperService {

    private final ResourceMapperService resourceMapperService;

    @Override
    public ResourceResponse toDTO(EducationResource resource) {
        return resourceMapperService.toDTO(resource);
    }

    @Override
    public EducationResource toEntity(ResourceRequest dto) {
        return (EducationResource) resourceMapperService.toEntity(dto);
    }



    @Override
    public EducationResource toEntity(EducationResource resource, ResourceRequest dto) {
        return (EducationResource) resourceMapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceMapperService.fileToRequest(file,url);
    }

    @Override
    public EducationResource toEntity(MultipartFile file, String resourceStoragePath) {
        return convert(new EducationResource(),resourceMapperService.toEntity(file, resourceStoragePath));
    }
    @Override
    public EducationResource toEntity(EducationResource resource, MultipartFile file, String resourceStoragePath) {
        return convert(resource,resourceMapperService.toEntity(resource,file,resourceStoragePath));
    }

    private EducationResource convert(EducationResource educationResource, Resource resource) {
        educationResource.setFileName(resource.getFileName());
        educationResource.setContentType(resource.getContentType());
        educationResource.setSizeInBytes(resource.getSizeInBytes());
        educationResource.setUrl(resource.getUrl());
        return educationResource;
    }

    @Override
    public EducationResource copy(EducationResource educationResource) {
        Resource resource = resourceMapperService.copy(educationResource);
        return convert(new EducationResource(),resource);
    }
}
