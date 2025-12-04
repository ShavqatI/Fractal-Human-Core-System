package com.fractal.domain.order.bonus.mapper;

import com.fractal.domain.order.bonus.BonusOrder;
import com.fractal.domain.order.bonus.dto.EmploymentOrderRequest;
import com.fractal.domain.order.bonus.dto.BonusOrderResponse;

public interface BonusOrderMapperService {
    BonusOrderResponse toDTO(BonusOrder order);

    BonusOrder toEntity(EmploymentOrderRequest dto);

    BonusOrder toEntity(BonusOrder order, EmploymentOrderRequest dto);
}


