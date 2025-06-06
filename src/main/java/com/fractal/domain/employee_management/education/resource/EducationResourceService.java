package com.fractal.domain.employee_management.education.resource;

import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface EducationResourceService {

    ResourceResponse toDTO(EducationResource resource);
    EducationResource toEntity(ResourceRequest dto);
    EducationResource toEntity(MultipartFile file, String url);
    EducationResource update(EducationResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    void delete(EducationResource resource);
    EducationResource findById(Long id);
}
