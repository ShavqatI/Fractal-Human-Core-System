package com.fractal.domain.vacation_management.order.mapper;

import com.fractal.domain.vacation_management.order.VacationOrder;
import com.fractal.domain.vacation_management.order.dto.VacationOrderRequest;
import com.fractal.domain.vacation_management.order.dto.VacationOrderResponse;

public interface VacationOrderMapperService {
    VacationOrderResponse toDTO(VacationOrder order);
    VacationOrder toEntity(VacationOrderRequest dto);
    VacationOrder toEntity(VacationOrder order, VacationOrderRequest dto);
}


