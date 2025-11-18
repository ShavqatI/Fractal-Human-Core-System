package com.fractal.domain.order.employment.mapper;

import com.fractal.domain.order.employment.InternalEmploymentOrder;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderResponse;

public interface BusinessTripOrderMapperService {
    InternalEmploymentOrderResponse toDTO(InternalEmploymentOrder order);

    InternalEmploymentOrder toEntity(InternalEmploymentOrderRequest dto);

    InternalEmploymentOrder toEntity(InternalEmploymentOrder order, InternalEmploymentOrderRequest dto);
}


