package com.fractal.domain.resource;

import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final ResourceMapperService resourceMapperService;
    @Override
    public ResourceResponse toDTO(Resource resource) {
        return resourceMapperService.toDTO(resource);
    }

    @Override
    public Resource toEntity(ResourceRequest dto) {
        return resourceMapperService.toEntity(dto);
    }

    @Override
    public Resource toEntity(MultipartFile file, String url) {
        return resourceMapperService.toEntity(file,url);
    }

    @Override
    public Resource toEntity(Resource resource, ResourceRequest dto) {
        return resourceMapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceMapperService.fileToRequest(file,url);
    }
}
