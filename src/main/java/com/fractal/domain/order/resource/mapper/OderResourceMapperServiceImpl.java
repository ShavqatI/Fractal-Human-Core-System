package com.fractal.domain.order.resource.mapper;

import com.fractal.domain.order.resource.OrderResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class OderResourceMapperServiceImpl implements OrderResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(OrderResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public OrderResource toEntity(ResourceRequest dto) {
        return (OrderResource) mapperService.toEntity(dto);
    }

    @Override
    public OrderResource toEntity(MultipartFile file, String url) {
        return (OrderResource) mapperService.toEntity(file,url);
    }

    @Override
    public OrderResource toEntity(OrderResource resource, ResourceRequest dto) {
        return (OrderResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
