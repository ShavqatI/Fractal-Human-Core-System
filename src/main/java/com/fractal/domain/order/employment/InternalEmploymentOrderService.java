package com.fractal.domain.order.employment;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.order.business_trip.BusinessTripOrder;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderResponse;

import java.util.List;

public interface InternalEmploymentOrderService extends ApprovalWorkflowAware<Long, InternalEmploymentOrder> {

    InternalEmploymentOrder create(InternalEmploymentOrderRequest dto);

    List<InternalEmploymentOrder> getAll();

    InternalEmploymentOrder getById(Long id);

    InternalEmploymentOrder update(Long id, InternalEmploymentOrderRequest dto);

    void delete(Long id);

    InternalEmploymentOrderResponse toDTO(InternalEmploymentOrder internalEmploymentOrder);

    InternalEmploymentOrder save(InternalEmploymentOrder order);


}
