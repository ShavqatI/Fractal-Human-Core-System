package com.fractal.domain.order.business_trip.mapper;

import com.fractal.domain.order.business_trip.BusinessTripOrder;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;

public interface BusinessTripOrderMapperService {
    BusinessTripOrderResponse toDTO(BusinessTripOrder order);

    BusinessTripOrder toEntity(BusinessTripOrderRequest dto);

    BusinessTripOrder toEntity(BusinessTripOrder order, BusinessTripOrderRequest dto);
}


