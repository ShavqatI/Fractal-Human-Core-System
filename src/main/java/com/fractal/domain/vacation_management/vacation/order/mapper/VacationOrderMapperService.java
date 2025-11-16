package com.fractal.domain.vacation_management.vacation.order.mapper;

import com.fractal.domain.vacation_management.vacation.order.VacationOrder;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderRequest;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderResponse;

public interface VacationOrderMapperService {
    VacationOrderResponse toDTO(VacationOrder order);

    VacationOrder toEntity(VacationOrderRequest dto);

    VacationOrder toEntity(VacationOrder order, VacationOrderRequest dto);
}


