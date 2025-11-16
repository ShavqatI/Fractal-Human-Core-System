package com.fractal.domain.order.resource.mapper;

import com.fractal.domain.order.resource.OrderResource;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class OderResourceMapperServiceImpl implements OrderResourceMapperService {

    private final ResourceMapperService resourceMapperService;

    @Override
    public ResourceResponse toDTO(OrderResource resource) {
        return resourceMapperService.toDTO(resource);
    }

    @Override
    public OrderResource toEntity(ResourceRequest dto) {
        return (OrderResource) resourceMapperService.toEntity(dto);
    }

    @Override
    public OrderResource toEntity(MultipartFile file, String resourceStoragePath) {
        return convert(new OrderResource(), resourceMapperService.toEntity(file, resourceStoragePath));
    }

    @Override
    public OrderResource toEntity(OrderResource resource, MultipartFile file, String resourceStoragePath) {
        return convert(resource, resourceMapperService.toEntity(resource, file, resourceStoragePath));
    }

    @Override
    public OrderResource toEntity(OrderResource resource, ResourceRequest dto) {
        return (OrderResource) resourceMapperService.toEntity(resource, dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceMapperService.fileToRequest(file, url);
    }

    private OrderResource convert(OrderResource orderResource, Resource resource) {
        orderResource.setFileName(resource.getFileName());
        orderResource.setContentType(resource.getContentType());
        orderResource.setSizeInBytes(resource.getSizeInBytes());
        orderResource.setUrl(resource.getUrl());
        return orderResource;
    }
}
