
package com.fractal.domain.order.employment.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.order.employment.EmploymentOrder;
import com.fractal.domain.order.employment.dto.EmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.EmploymentOrderResponse;
import com.fractal.domain.order.employment.record.mapper.EmploymentOrderRecordMapperService;
import com.fractal.domain.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.order.type.OrderTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EmploymentOrderMapperServiceImpl implements EmploymentOrderMapperService {

    private final OrderTypeService orderTypeService;
    private final OrderResourceMapperService resourceMapperService;
    private final StatusService statusService;
    private final EmploymentOrderRecordMapperService recordMapperService;
    private final EmployeeService employeeService;

    @Override
    public EmploymentOrderResponse toDTO(EmploymentOrder order) {
        return new EmploymentOrderResponse(
                order.getId(),
                orderTypeService.toDTO(order.getOrderType()),
                employeeService.toCompactDTO(order.getRecords().get(0).getEmployment().getEmployee()),
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
    public EmploymentOrder toEntity(EmploymentOrderRequest dto) {
        return mapToEntity(new EmploymentOrder(), dto);
    }

    @Override
    public EmploymentOrder toEntity(EmploymentOrder order, EmploymentOrderRequest dto) {
        return mapToEntity(order, dto);
    }

    private EmploymentOrder mapToEntity(EmploymentOrder order, EmploymentOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        order.setNumber(dto.number());
        order.setDate(dto.date());
        order.setSourceDocument(dto.sourceDocument());
        dto.files().forEach(file -> order.addResource(resourceMapperService.toEntity(file, null)));
        dto.records().forEach(record-> order.addRecord(recordMapperService.toEntity(record)));
        return order;
    }

}

