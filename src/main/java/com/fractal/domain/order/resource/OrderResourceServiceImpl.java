package com.fractal.domain.order.resource;

import com.fractal.domain.order.OrderService;
import com.fractal.domain.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderResourceServiceImpl implements OrderResourceService {

    private final OrderResourceRepository resourceRepository;
    private final OrderResourceMapperService resourceMapperService;
    private final OrderService orderService;
    private final FileService fileService;

    @Value("${resource-storage.order}")
    private String resourceStoragePath;

    @Override
    public OrderResource create(Long orderId, MultipartFile file) {
        var order = orderService.getById(orderId);
        var resource =  resourceMapperService.toEntity(file,resourceStoragePath);
        order.addResource(resource);
        orderService.save(order);
        return resource;
    }

    @Override
    public List<OrderResource> getAllByOrderId(Long orderId) {
        return resourceRepository.findAllByOrderId(orderId);
    }

    @Override
    public OrderResource getById(Long orderId, Long id) {
        return resourceRepository.findByOrderIdAndId(orderId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public OrderResource update(Long educationId, Long id, MultipartFile file) {
        var order = orderService.getById(educationId);
        var resource = order.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        resource = resourceMapperService.toEntity(resource,file,resourceStoragePath);
        resourceRepository.save(resource);
        orderService.save(order);
        return resource;
    }

    @Override
    public void delete(Long orderId, Long id) {
        var order = orderService.getById(orderId);
        var resource = order.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        fileService.delete(resource.getUrl());
        order.removeResource(resource);
        orderService.save(order);
    }

    @Override
    public ResourceResponse toDTO(OrderResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
