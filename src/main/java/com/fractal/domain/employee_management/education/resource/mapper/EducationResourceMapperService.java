package com.fractal.domain.employee_management.education.resource.mapper;

import com.fractal.domain.employee_management.education.resource.EducationResource;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface EducationResourceMapperService {
    ResourceResponse toDTO(EducationResource resource);
    EducationResource toEntity(ResourceRequest dto);
    EducationResource toEntity(MultipartFile file, String url);
    EducationResource toEntity(EducationResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
}


