package com.fractal.domain.resource.mapper;

import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ResourceMapperService {

    ResourceResponse toDTO(Resource resource);

    Resource toEntity(ResourceRequest dto);

    Resource toEntity(MultipartFile file, String resourceStoragePath);

    Resource toEntity(Resource resource, MultipartFile file, String resourceStoragePath);

    Resource toEntity(Resource resource, ResourceRequest dto);

    ResourceRequest fileToRequest(MultipartFile file, String url);

    Resource copy(Resource resource);


}
