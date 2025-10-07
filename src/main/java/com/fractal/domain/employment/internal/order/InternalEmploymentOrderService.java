package com.fractal.domain.employment.internal.order;

import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderResponse;

import java.util.List;

public interface InternalEmploymentOrderService {

    InternalEmploymentOrder create(Long employmentId, InternalEmploymentOrderRequest dto);
    List<InternalEmploymentOrder> getAllByInternalEmploymentId(Long employmentId);
    InternalEmploymentOrder getById(Long employmentId , Long id);
    InternalEmploymentOrder update(Long employmentId, Long id, InternalEmploymentOrderRequest dto);
    void delete(Long employmentId,Long id);
    InternalEmploymentOrderResponse toDTO(InternalEmploymentOrder order);

}
