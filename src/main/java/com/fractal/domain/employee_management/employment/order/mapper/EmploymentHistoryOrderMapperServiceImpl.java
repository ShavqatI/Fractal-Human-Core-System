package com.fractal.domain.employee_management.employment.order.mapper;

import com.fractal.domain.employee_management.employment.order.EmploymentHistoryOrder;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderRequest;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderResponse;
import com.fractal.domain.employee_management.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.employee_management.order.type.OrderTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EmploymentHistoryOrderMapperServiceImpl implements EmploymentHistoryOrderMapperService {

    private final OrderTypeService orderTypeService;
    private final OrderResourceMapperService resourceMapperService;

    @Override
    public EmploymentHistoryOrderResponse toDTO(EmploymentHistoryOrder order) {
        return new EmploymentHistoryOrderResponse(
                   order.getId(),
                   order.getNumber(),
                   orderTypeService.toDTO(order.getOrderType()),
                   Optional.ofNullable(order.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                   order.getCreatedDate()

        );
    }

    @Override
    public EmploymentHistoryOrder toEntity(EmploymentHistoryOrderRequest dto) {
        return mapToEntity(new EmploymentHistoryOrder(),dto);
    }

    @Override
    public EmploymentHistoryOrder toEntity(EmploymentHistoryOrder order, EmploymentHistoryOrderRequest dto) {
        return mapToEntity(order,dto);
    }

    private EmploymentHistoryOrder mapToEntity(EmploymentHistoryOrder order, EmploymentHistoryOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        dto.files().forEach(file-> order.addResource(resourceMapperService.toEntity(file,null)));
        return order;
    }

}
