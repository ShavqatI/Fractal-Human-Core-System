package com.fractal.domain.integration.mapping.order_type;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.integration.mapping.order_type.dto.OrderTypeMappingRequest;
import com.fractal.domain.integration.mapping.order_type.dto.OrderTypeMappingResponse;
import com.fractal.domain.order.type.OrderTypeService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class OrderTypeMappingServiceImpl implements OrderTypeMappingService {

    private final OrderTypeMappingRepository orderTypeMappingRepository;
    private final OrderTypeService orderTypeService;
    private final StatusService statusService;

    @Override
    public OrderTypeMapping create(OrderTypeMappingRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<OrderTypeMapping> getAll() {
        return orderTypeMappingRepository.findAll();
    }
    @Override
    public OrderTypeMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public OrderTypeMapping update(Long id, OrderTypeMappingRequest dto) {
        try {
            OrderTypeMapping orderTypeMapping = findById(id);
            orderTypeMapping.setOrderType(orderTypeService.getById(dto.orderTypeId()));
            orderTypeMapping.setReferenceType(dto.referenceType());
            orderTypeMapping.setReference(dto.reference());
            orderTypeMapping.setStatus(statusService.getById(dto.statusId()));
            return save(orderTypeMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        orderTypeMappingRepository.delete(findById(id));
    }

    @Override
    public OrderTypeMappingResponse toDTO(OrderTypeMapping orderTypeMapping) {
        return new OrderTypeMappingResponse(
                orderTypeMapping.getId(),
                orderTypeService.toDTO(orderTypeMapping.getOrderType()),
                orderTypeMapping.getReferenceType(),
                orderTypeMapping.getReference(),
                statusService.toCompactDTO(orderTypeMapping.getStatus()),
                orderTypeMapping.getCreatedDate()
        );
    }

    private OrderTypeMapping toEntity(OrderTypeMappingRequest dto) {
        return OrderTypeMapping.builder()
                .orderType(orderTypeService.getById(dto.orderTypeId()))
                .referenceType(dto.referenceType())
                .reference(dto.reference())
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private OrderTypeMapping save(OrderTypeMapping orderTypeMapping) {
        try {
            return orderTypeMappingRepository.save(orderTypeMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OrderTypeMapping findById(Long id) {
        return orderTypeMappingRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
