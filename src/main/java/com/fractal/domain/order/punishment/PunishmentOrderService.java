package com.fractal.domain.order.punishment;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.order.punishment.dto.PunishmentOrderRequest;
import com.fractal.domain.order.punishment.dto.PunishmentOrderResponse;

import java.nio.file.Path;
import java.util.List;

public interface PunishmentOrderService extends ApprovalWorkflowAware<Long, PunishmentOrder> {

    PunishmentOrder create(PunishmentOrderRequest dto);

    List<PunishmentOrder> getAll();

    PunishmentOrder getById(Long id);

    PunishmentOrder update(Long id, PunishmentOrderRequest dto);

    void delete(Long id);

    PunishmentOrderResponse toDTO(PunishmentOrder punishmentOrder);

    Path print(Long id);

}
