package com.fractal.domain.military_service.resource.mapper;

import com.fractal.domain.military_service.resource.MilitaryServiceResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class MilitaryServiceResourceMapperServiceImpl implements MilitaryServiceResourceMapperService {

    private final ResourceMapperService resourceMapperService;

    @Override
    public ResourceResponse toDTO(MilitaryServiceResource resource) {
        return resourceMapperService.toDTO(resource);
    }

    @Override
    public MilitaryServiceResource toEntity(ResourceRequest dto) {
        return (MilitaryServiceResource) resourceMapperService.toEntity(dto);
    }

    @Override
    public MilitaryServiceResource toEntity(MultipartFile file, String url) {
        return (MilitaryServiceResource) resourceMapperService.toEntity(file,url);
    }

    @Override
    public MilitaryServiceResource toEntity(MilitaryServiceResource resource, ResourceRequest dto) {
        return (MilitaryServiceResource) resourceMapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceMapperService.fileToRequest(file,url);
    }
}
