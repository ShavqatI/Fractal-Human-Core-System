package com.fractal.domain.employee_management.business_trip.order;

import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderRequest;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderResponse;

import java.util.List;

public interface BusinessTripOrderService {

    BusinessTripOrder create(Long businessTripId, BusinessTripOrderRequest dto);
    List<BusinessTripOrder> getAllByBusinessTripId(Long businessTripId);
    BusinessTripOrder getById(Long businessTripId ,Long id);
    BusinessTripOrder update(Long businessTripId,Long id, BusinessTripOrderRequest dto);
    void delete(Long businessTripId,Long id);
    BusinessTripOrderResponse toDTO(BusinessTripOrder businessTripOrder);

}
