package com.fractal.domain.order.employment.mapper;

import com.fractal.domain.order.employment.EmploymentOrder;
import com.fractal.domain.order.employment.dto.EmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.EmploymentOrderResponse;

public interface EmploymentOrderMapperService {
    EmploymentOrderResponse toDTO(EmploymentOrder order);

    EmploymentOrder toEntity(EmploymentOrderRequest dto);

    EmploymentOrder toEntity(EmploymentOrder order, EmploymentOrderRequest dto);
}


