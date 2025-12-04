
package com.fractal.domain.order.bonus.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.bonus.BonusOrder;
import com.fractal.domain.order.bonus.dto.EmploymentOrderRequest;
import com.fractal.domain.order.bonus.dto.BonusOrderResponse;
import com.fractal.domain.order.bonus.record.mapper.BonusOrderRecordMapperService;
import com.fractal.domain.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.order.type.OrderTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class BonusOrderMapperServiceImpl implements BonusOrderMapperService {

    private final OrderTypeService orderTypeService;
    private final OrderResourceMapperService resourceMapperService;
    private final StatusService statusService;
    private final BonusOrderRecordMapperService recordMapperService;

    @Override
    public BonusOrderResponse toDTO(BonusOrder order) {
        return new BonusOrderResponse(
                order.getId(),
                orderTypeService.toDTO(order.getOrderType()),
                Optional.ofNullable(order.getRecords())
                        .orElse(emptyList())
                        .stream()
                        .map(recordMapperService::toDTO)
                        .collect(Collectors.toList()),
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
    public BonusOrder toEntity(EmploymentOrderRequest dto) {
        return mapToEntity(new BonusOrder(), dto);
    }

    @Override
    public BonusOrder toEntity(BonusOrder order, EmploymentOrderRequest dto) {
        return mapToEntity(order, dto);
    }

    private BonusOrder mapToEntity(BonusOrder order, EmploymentOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        order.setNumber(dto.number());
        order.setDate(dto.date());
        dto.files().forEach(file -> order.addResource(resourceMapperService.toEntity(file, null)));
        dto.records().forEach(record-> order.addRecord(recordMapperService.toEntity(record)));
        return order;
    }

}

