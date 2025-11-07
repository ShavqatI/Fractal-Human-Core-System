package com.fractal.domain.identification_document.resource.mapper;

import com.fractal.domain.education.Education;
import com.fractal.domain.employee_management.education.EmployeeEducation;
import com.fractal.domain.identification_document.IdentificationDocument;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.military_service.MilitaryService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
class IdentificationDocumentResourceMapperServiceImpl implements IdentificationDocumentResourceMapperService {

    private final ResourceMapperService resourceMapperService;

    @Override
    public ResourceResponse toDTO(IdentificationDocumentResource resource) {
        return resourceMapperService.toDTO(resource);
    }

    @Override
    public IdentificationDocumentResource copy(IdentificationDocumentResource identificationDocumentResource) {
        Resource resource = resourceMapperService.copy(identificationDocumentResource);
        return convert(new IdentificationDocumentResource(),resource);
    }

    @Override
    public IdentificationDocumentResource toEntity(ResourceRequest dto) {
        return (IdentificationDocumentResource) resourceMapperService.toEntity(dto);
    }

    @Override
    public IdentificationDocumentResource toEntity(MultipartFile file, String resourceStoragePath) {
        return convert(new IdentificationDocumentResource(),resourceMapperService.toEntity(file, resourceStoragePath));
    }
    @Override
    public IdentificationDocumentResource toEntity(IdentificationDocumentResource resource, MultipartFile file, String resourceStoragePath) {
        return convert(resource,resourceMapperService.toEntity(resource,file,resourceStoragePath));
    }

    @Override
    public IdentificationDocumentResource toEntity(IdentificationDocumentResource resource, ResourceRequest dto) {
        return (IdentificationDocumentResource) resourceMapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceMapperService.fileToRequest(file,url);
    }
    private IdentificationDocumentResource convert(IdentificationDocumentResource identificationDocumentResource, Resource resource) {
        identificationDocumentResource.setFileName(resource.getFileName());
        identificationDocumentResource.setContentType(resource.getContentType());
        identificationDocumentResource.setSizeInBytes(resource.getSizeInBytes());
        identificationDocumentResource.setUrl(resource.getUrl());
        return identificationDocumentResource;
    }




}
