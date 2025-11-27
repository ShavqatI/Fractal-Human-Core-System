package com.fractal.domain.order.business_trip;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;

import java.nio.file.Path;
import java.util.List;

public interface BusinessTripOrderService extends ApprovalWorkflowAware<Long, BusinessTripOrder> {

    BusinessTripOrder create(BusinessTripOrderRequest dto);

    List<BusinessTripOrder> getAll();

    BusinessTripOrder getById(Long id);

    BusinessTripOrder update(Long id, BusinessTripOrderRequest dto);

    void delete(Long id);


    BusinessTripOrderResponse toDTO(BusinessTripOrder businessTripOrder);

    BusinessTripOrder save(BusinessTripOrder order);
    Path print(Long id);


}
