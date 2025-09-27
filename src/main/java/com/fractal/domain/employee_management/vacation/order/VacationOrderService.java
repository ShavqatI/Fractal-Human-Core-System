package com.fractal.domain.employee_management.vacation.order;

import com.fractal.domain.employee_management.vacation.order.dto.VacationOrderRequest;
import com.fractal.domain.employee_management.vacation.order.dto.VacationOrderResponse;

import java.util.List;

public interface VacationOrderService {

    VacationOrder create(Long vacationId, VacationOrderRequest dto);
    List<VacationOrder> getAllByVacationId(Long vacationId);
    VacationOrder getById(Long vacationId , Long id);
    VacationOrder update(Long vacationId, Long id, VacationOrderRequest dto);
    void delete(Long vacationId,Long id);
    VacationOrderResponse toDTO(VacationOrder vacationOrder);

}
