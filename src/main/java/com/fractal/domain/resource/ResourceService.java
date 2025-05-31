package com.fractal.domain.resource;

import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ResourceService {

    ResourceResponse toDTO(Resource resource);
    Resource toEntity(ResourceRequest dto);
    Resource toEntity(MultipartFile file, String url);
    ResourceRequest fileToRequest(MultipartFile file,String url);

}
