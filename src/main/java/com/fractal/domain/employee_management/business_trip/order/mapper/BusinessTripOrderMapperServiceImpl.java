package com.fractal.domain.employee_management.business_trip.order.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.order.BusinessTripOrder;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderRequest;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderResponse;
import com.fractal.domain.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.order.type.OrderTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class BusinessTripOrderMapperServiceImpl implements BusinessTripOrderMapperService {

    private final OrderTypeService orderTypeService;
    private final OrderResourceMapperService resourceMapperService;
    private final StatusService statusService;

    @Override
    public BusinessTripOrderResponse toDTO(BusinessTripOrder order) {
        return new BusinessTripOrderResponse(
                order.getId(),
                orderTypeService.toDTO(order.getOrderType()),
                order.getNumber(),
                order.getDate(),
                statusService.toCompactDTO(order.getStatus()),
                Optional.ofNullable(order.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                order.getCreatedDate()

        );
    }

    @Override
    public BusinessTripOrder toEntity(BusinessTripOrderRequest dto) {
        return mapToEntity(new BusinessTripOrder(), dto);
    }

    @Override
    public BusinessTripOrder toEntity(BusinessTripOrder order, BusinessTripOrderRequest dto) {
        return mapToEntity(order, dto);
    }

    private BusinessTripOrder mapToEntity(BusinessTripOrder order, BusinessTripOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        order.setNumber(dto.number());
        order.setDate(dto.date());
        order.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file -> order.addResource(resourceMapperService.toEntity(file, null)));
        return order;
    }

}
