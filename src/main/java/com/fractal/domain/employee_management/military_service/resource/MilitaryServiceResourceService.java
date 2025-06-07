package com.fractal.domain.employee_management.military_service.resource;

import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MilitaryServiceResourceService {

    ResourceResponse toDTO(MilitaryServiceResource resource);
    MilitaryServiceResource toEntity(ResourceRequest dto);
    MilitaryServiceResource toEntity(MultipartFile file, String url);
    MilitaryServiceResource update(MilitaryServiceResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    void delete(MilitaryServiceResource resource);
    MilitaryServiceResource findById(Long id);
}
