package com.fractal.domain.employment.internal.order.mapper;

import com.fractal.domain.employment.internal.order.InternalEmploymentOrder;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderResponse;

public interface InternalEmploymentOrderMapperService {
    InternalEmploymentOrderResponse toDTO(InternalEmploymentOrder order);
    InternalEmploymentOrder toEntity(InternalEmploymentOrderRequest dto);
    InternalEmploymentOrder toEntity(InternalEmploymentOrder order, InternalEmploymentOrderRequest dto);
}


