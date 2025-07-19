package com.fractal.domain.employee_management.employment.order;

import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderRequest;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderResponse;

import java.util.List;

public interface EmploymentHistoryOrderService {

    EmploymentHistoryOrder create(Long employmentHistoryId, EmploymentHistoryOrderRequest dto);
    List<EmploymentHistoryOrder> getAllByEmploymentHistoryId(Long employmentHistoryId);
    EmploymentHistoryOrder getById(Long employmentHistoryId , Long id);
    EmploymentHistoryOrder update(Long employmentHistoryId, Long id, EmploymentHistoryOrderRequest dto);
    void delete(Long businessTripId,Long id);
    EmploymentHistoryOrderResponse toDTO(EmploymentHistoryOrder employmentHistoryOrder);

}
