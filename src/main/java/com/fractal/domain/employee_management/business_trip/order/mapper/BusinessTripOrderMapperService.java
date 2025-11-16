package com.fractal.domain.employee_management.business_trip.order.mapper;

import com.fractal.domain.employee_management.business_trip.order.BusinessTripOrder;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderRequest;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderResponse;

public interface BusinessTripOrderMapperService {
    BusinessTripOrderResponse toDTO(BusinessTripOrder order);

    BusinessTripOrder toEntity(BusinessTripOrderRequest dto);

    BusinessTripOrder toEntity(BusinessTripOrder order, BusinessTripOrderRequest dto);
}


