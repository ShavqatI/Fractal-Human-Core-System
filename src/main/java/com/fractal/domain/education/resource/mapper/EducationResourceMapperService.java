package com.fractal.domain.education.resource.mapper;

import com.fractal.domain.education.resource.EducationResource;
import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface EducationResourceMapperService {
    ResourceResponse toDTO(EducationResource resource);
    EducationResource toEntity(ResourceRequest dto);
    EducationResource toEntity(MultipartFile file, String resourceStoragePath);
    EducationResource toEntity(EducationResource resource, MultipartFile file, String resourceStoragePath);
    EducationResource toEntity(EducationResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    EducationResource copy(EducationResource educationResource);
}


