package com.fractal.domain.employee_management.vacation.order.mapper;

import com.fractal.domain.employee_management.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.employee_management.order.type.OrderTypeService;
import com.fractal.domain.employee_management.vacation.order.VacationOrder;
import com.fractal.domain.employee_management.vacation.order.dto.VacationOrderRequest;
import com.fractal.domain.employee_management.vacation.order.dto.VacationOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class VacationOrderMapperServiceImpl implements VacationOrderMapperService {

    private final OrderTypeService orderTypeService;
    private final OrderResourceMapperService resourceMapperService;

    @Override
    public VacationOrderResponse toDTO(VacationOrder order) {
        return new VacationOrderResponse(
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
    public VacationOrder toEntity(VacationOrderRequest dto) {
        return mapToEntity(new VacationOrder(),dto);
    }

    @Override
    public VacationOrder toEntity(VacationOrder order, VacationOrderRequest dto) {
        return mapToEntity(order,dto);
    }

    private VacationOrder mapToEntity(VacationOrder order, VacationOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        dto.files().forEach(file-> order.addResource(resourceMapperService.toEntity(file,null)));
        return order;
    }

}
