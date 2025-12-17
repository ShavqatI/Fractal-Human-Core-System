package com.fractal.domain.order.punishment.mapper;

import com.fractal.domain.order.punishment.PunishmentOrder;
import com.fractal.domain.order.punishment.dto.PunishmentOrderRequest;
import com.fractal.domain.order.punishment.dto.PunishmentOrderResponse;

public interface PunishmentOrderMapperService {
    PunishmentOrderResponse toDTO(PunishmentOrder order);
    PunishmentOrder toEntity(PunishmentOrderRequest dto);
    PunishmentOrder toEntity(PunishmentOrder order, PunishmentOrderRequest dto);
}


