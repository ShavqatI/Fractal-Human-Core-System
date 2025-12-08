
package com.fractal.domain.order.recognition.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.recognition.RecognitionOrder;
import com.fractal.domain.order.recognition.dto.EmploymentOrderRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderResponse;
import com.fractal.domain.order.recognition.record.mapper.RecognitionOrderRecordMapperService;
import com.fractal.domain.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.order.type.OrderTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class RecognitionOrderMapperServiceImpl implements RecognitionOrderMapperService {

    private final OrderTypeService orderTypeService;
    private final OrderResourceMapperService resourceMapperService;
    private final StatusService statusService;
    private final RecognitionOrderRecordMapperService recordMapperService;

    @Override
    public RecognitionOrderResponse toDTO(RecognitionOrder order) {
        return new RecognitionOrderResponse(
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
    public RecognitionOrder toEntity(EmploymentOrderRequest dto) {
        return mapToEntity(new RecognitionOrder(), dto);
    }

    @Override
    public RecognitionOrder toEntity(RecognitionOrder order, EmploymentOrderRequest dto) {
        return mapToEntity(order, dto);
    }

    private RecognitionOrder mapToEntity(RecognitionOrder order, EmploymentOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        order.setNumber(dto.number());
        order.setDate(dto.date());
        dto.files().forEach(file -> order.addResource(resourceMapperService.toEntity(file, null)));
        dto.records().forEach(record-> order.addRecord(recordMapperService.toEntity(record)));
        return order;
    }

}

