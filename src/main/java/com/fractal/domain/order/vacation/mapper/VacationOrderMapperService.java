package com.fractal.domain.order.vacation.mapper;

import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;

public interface VacationOrderMapperService {
    VacationOrderResponse toDTO(VacationOrder order);

    VacationOrder toEntity(VacationOrderRequest dto);

    VacationOrder toEntity(VacationOrder order, VacationOrderRequest dto);
}


