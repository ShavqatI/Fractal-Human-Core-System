
package com.fractal.domain.order.employment.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.employment.InternalEmploymentOrder;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderResponse;
import com.fractal.domain.order.employment.record.mapper.InternalEmploymentOrderRecordMapperService;
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
    private final InternalEmploymentOrderRecordMapperService recordMapperService;

    @Override
    public InternalEmploymentOrderResponse toDTO(InternalEmploymentOrder order) {
        return new InternalEmploymentOrderResponse(
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
    public InternalEmploymentOrder toEntity(InternalEmploymentOrderRequest dto) {
        return mapToEntity(new InternalEmploymentOrder(), dto);
    }

    @Override
    public InternalEmploymentOrder toEntity(InternalEmploymentOrder order, InternalEmploymentOrderRequest dto) {
        return mapToEntity(order, dto);
    }

    private InternalEmploymentOrder mapToEntity(InternalEmploymentOrder order, InternalEmploymentOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        order.setNumber(dto.number());
        order.setDate(dto.date());
        order.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file -> order.addResource(resourceMapperService.toEntity(file, null)));
        dto.records().forEach(record-> order.addRecord(recordMapperService.toEntity(record)));
        return order;
    }

}

