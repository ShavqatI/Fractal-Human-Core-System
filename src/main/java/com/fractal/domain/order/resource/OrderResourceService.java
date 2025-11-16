package com.fractal.domain.order.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OrderResourceService {

    OrderResource create(Long orderId, MultipartFile file);

    List<OrderResource> getAllByOrderId(Long orderId);

    OrderResource getById(Long orderId, Long id);

    OrderResource update(Long orderId, Long id, MultipartFile file);

    void delete(Long orderId, Long id);

    ResourceResponse toDTO(OrderResource resource);
}
