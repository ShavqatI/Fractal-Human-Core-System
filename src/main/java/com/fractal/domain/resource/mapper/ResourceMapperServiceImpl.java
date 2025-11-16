package com.fractal.domain.resource.mapper;

import com.fractal.domain.resource.FileService;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ResourceMapperServiceImpl implements ResourceMapperService {

    private final FileService fileService;

    @Override
    public ResourceResponse toDTO(Resource resource) {
        return new ResourceResponse(
                resource.getId(),
                resource.getUrl(),
                resource.getFileName(),
                resource.getContentType(),
                resource.getSizeInBytes(),
                resource.getCreatedDate()
        );
    }

    @Override
    public Resource toEntity(ResourceRequest dto) {
        return mapToEntity(new Resource(), dto);
    }

    @Override
    public Resource toEntity(MultipartFile file, String resourceStoragePath) {
        return mapToEntity(new Resource(), file, resourceStoragePath);
    }

    @Override
    public Resource toEntity(Resource resource, MultipartFile file, String resourceStoragePath) {
        return mapToEntity(resource, file, resourceStoragePath);
    }

    @Override
    public Resource toEntity(Resource resource, ResourceRequest dto) {
        return mapToEntity(resource, dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return new ResourceRequest(url, file.getOriginalFilename(), file.getContentType(), file.getSize());
    }


    private Resource mapToEntity(Resource resource, ResourceRequest dto) {
        fileService.delete(resource.getUrl());
        resource.setUrl(dto.url());
        resource.setFileName(dto.fileName());
        resource.setContentType(dto.contentType());
        resource.setSizeInBytes(dto.sizeInBytes());
        return resource;
    }

    private Resource mapToEntity(Resource resource, MultipartFile file, String resourceStoragePath) {
        fileService.delete(resource.getUrl());
        resource.setFileName(file.getOriginalFilename());
        resource.setContentType(file.getContentType());
        resource.setSizeInBytes(file.getSize());
        resource.setUrl(fileService.save(file, resourceStoragePath));
        return resource;
    }

    @Override
    public Resource copy(Resource resource) {
        Resource copy = Resource.builder().build();
        copy.setFileName(resource.getFileName());
        copy.setContentType(resource.getContentType());
        copy.setSizeInBytes(resource.getSizeInBytes());
        copy.setUrl(fileService.copy(resource.getUrl()));
        return copy;
    }


}
