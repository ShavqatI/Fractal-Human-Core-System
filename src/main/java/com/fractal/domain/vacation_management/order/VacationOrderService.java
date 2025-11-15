package com.fractal.domain.vacation_management.order;

import com.fractal.domain.vacation_management.order.dto.VacationOrderRequest;
import com.fractal.domain.vacation_management.order.dto.VacationOrderResponse;

import java.util.List;

public interface VacationOrderService {

    VacationOrder create(Long vacationId, VacationOrderRequest dto);
    List<VacationOrder> getAllByVacationId(Long vacationId);
    VacationOrder getById(Long vacationId , Long id);
    VacationOrder update(Long vacationId, Long id, VacationOrderRequest dto);
    void delete(Long vacationId,Long id);
    VacationOrderResponse toDTO(VacationOrder vacationOrder);

}
