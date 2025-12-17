package com.fractal.domain.order.punishment.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.punishment.PunishmentService;
import com.fractal.domain.order.punishment.PunishmentOrder;
import com.fractal.domain.order.punishment.dto.PunishmentOrderRequest;
import com.fractal.domain.order.punishment.dto.PunishmentOrderResponse;
import com.fractal.domain.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.order.type.OrderTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class PunishmentOrderMapperServiceImpl implements PunishmentOrderMapperService {

    private final OrderTypeService orderTypeService;
    private final OrderResourceMapperService resourceMapperService;
    private final StatusService statusService;
    private final PunishmentService punishmentService;
    private final EmployeeEmploymentService employeeEmploymentService;
    @Override
    public PunishmentOrderResponse toDTO(PunishmentOrder order) {
        return new PunishmentOrderResponse(
                order.getId(),
                orderTypeService.toDTO(order.getOrderType()),
                punishmentService.toDTO(order.getPunishment()),
                order.getNumber(),
                order.getDate(),
                order.getSourceDocument(),
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
    public PunishmentOrder toEntity(PunishmentOrderRequest dto) {
        var order = mapToEntity(new PunishmentOrder(), dto);
        order.setStatus(statusService.getByCode("CREATED"));
        return order;
    }

    @Override
    public PunishmentOrder toEntity(PunishmentOrder order, PunishmentOrderRequest dto) {
        return mapToEntity(order, dto);
    }

    private PunishmentOrder mapToEntity(PunishmentOrder order, PunishmentOrderRequest dto) {
        order.setOrderType(orderTypeService.getById(dto.orderTypeId()));
        order.setNumber(dto.number());
        order.setDate(dto.date());
        order.setSourceDocument(dto.sourceDocument());
        dto.files().forEach(file -> order.addResource(resourceMapperService.toEntity(file, null)));
        var employeeEmployment = employeeEmploymentService.getActiveEmployment(dto.employeeId());
        if(employeeEmployment != null) {
          var punishment = punishmentService.create(employeeEmployment.getEmployment().getId(),dto.punishment());
          order.setPunishment(punishment);
        }
       return order;
    }

}
