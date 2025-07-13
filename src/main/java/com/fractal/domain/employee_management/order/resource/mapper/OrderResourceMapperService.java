package com.fractal.domain.employee_management.order.resource.mapper;

import com.fractal.domain.employee_management.order.resource.OrderResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface OrderResourceMapperService {
    ResourceResponse toDTO(OrderResource resource);
    OrderResource toEntity(ResourceRequest dto);
    OrderResource toEntity(MultipartFile file, String url);
    OrderResource toEntity(OrderResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
}


