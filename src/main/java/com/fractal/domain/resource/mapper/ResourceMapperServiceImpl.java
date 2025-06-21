package com.fractal.domain.resource.mapper;

import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ResourceMapperServiceImpl implements ResourceMapperService {
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
        return mapToEntity(new Resource(),dto);
    }

    @Override
    public Resource toEntity(MultipartFile file,String url) {
        return toEntity(fileToRequest(file,url));
    }

    @Override
    public Resource toEntity(Resource resource, ResourceRequest dto) {
        return mapToEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return new ResourceRequest(url,file.getOriginalFilename(),file.getContentType(),file.getSize());
    }


    private Resource mapToEntity(Resource resource, ResourceRequest dto) {
        resource.setUrl(dto.url());
        resource.setFileName(dto.fileName());
        resource.setContentType(dto.contentType());
        resource.setSizeInBytes(dto.sizeInBytes());
        return resource;
    }


}
