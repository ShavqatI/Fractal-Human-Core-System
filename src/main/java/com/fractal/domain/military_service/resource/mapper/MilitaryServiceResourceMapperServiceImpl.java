package com.fractal.domain.military_service.resource.mapper;

import com.fractal.domain.military_service.resource.MilitaryServiceResource;
import com.fractal.domain.resource.Resource;
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
    public MilitaryServiceResource toEntity(MultipartFile file, String resourceStoragePath) {
        return convert(new MilitaryServiceResource(), resourceMapperService.toEntity(file, resourceStoragePath));
    }

    @Override
    public MilitaryServiceResource toEntity(MilitaryServiceResource resource, ResourceRequest dto) {
        return (MilitaryServiceResource) resourceMapperService.toEntity(resource, dto);
    }

    @Override
    public MilitaryServiceResource copy(MilitaryServiceResource militaryServiceResource) {
        Resource resource = resourceMapperService.copy(militaryServiceResource);
        return convert(new MilitaryServiceResource(), resource);
    }


    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String resourceStoragePath) {
        return resourceMapperService.fileToRequest(file, resourceStoragePath);
    }

    @Override
    public MilitaryServiceResource toEntity(MilitaryServiceResource resource, MultipartFile file, String resourceStoragePath) {
        return convert(resource, resourceMapperService.toEntity(resource, file, resourceStoragePath));
    }

    private MilitaryServiceResource convert(MilitaryServiceResource militaryServiceResource, Resource resource) {
        militaryServiceResource.setFileName(resource.getFileName());
        militaryServiceResource.setContentType(resource.getContentType());
        militaryServiceResource.setSizeInBytes(resource.getSizeInBytes());
        militaryServiceResource.setUrl(resource.getUrl());
        return militaryServiceResource;
    }
}
