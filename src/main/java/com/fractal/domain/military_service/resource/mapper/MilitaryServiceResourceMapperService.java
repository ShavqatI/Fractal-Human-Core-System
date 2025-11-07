package com.fractal.domain.military_service.resource.mapper;

import com.fractal.domain.education.resource.EducationResource;
import com.fractal.domain.military_service.resource.MilitaryServiceResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MilitaryServiceResourceMapperService {
    ResourceResponse toDTO(MilitaryServiceResource resource);
    MilitaryServiceResource toEntity(ResourceRequest dto);
    MilitaryServiceResource toEntity(MultipartFile file, String url);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    MilitaryServiceResource toEntity(MilitaryServiceResource resource, MultipartFile file, String resourceStoragePath);
    MilitaryServiceResource toEntity(MilitaryServiceResource resource, ResourceRequest dto);

    MilitaryServiceResource copy(MilitaryServiceResource resource);
}


