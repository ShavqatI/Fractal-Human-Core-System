package com.fractal.domain.order.vacation.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.order.type.OrderTypeService;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;
import com.fractal.domain.vacation_management.vacation.VacationService;
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
    private final StatusService statusService;
    private final VacationService vacationService;

    @Override
    public VacationOrderResponse toDTO(VacationOrder order) {
        return new VacationOrderResponse(
                order.getId(),
                orderTypeService.toDTO(order.getOrderType()),
                vacationService.toDTO(order.getVacation()),
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
    public VacationOrder toEntity(VacationOrderRequest dto) {
        return mapToEntity(new VacationOrder(), dto);
    }

    @Override
    public VacationOrder toEntity(VacationOrder order, VacationOrderRequest dto) {
        return mapToEntity(order, dto);
    }

    private VacationOrder mapToEntity(VacationOrder order, VacationOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        order.setNumber(dto.number());
        order.setDate(dto.date());
        dto.files().forEach(file -> order.addResource(resourceMapperService.toEntity(file, null)));
        if(order.getVacation() != null)
        vacationService.deleteById(order.getVacation().getId());
        order.setVacation(vacationService.create(dto.vacation()));
        return order;
    }

}
