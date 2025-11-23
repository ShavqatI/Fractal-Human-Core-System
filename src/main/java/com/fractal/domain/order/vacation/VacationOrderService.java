package com.fractal.domain.order.vacation;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;

import java.nio.file.Path;
import java.util.List;

public interface VacationOrderService extends ApprovalWorkflowAware<Long, VacationOrder> {

    VacationOrder create(VacationOrderRequest dto);

    List<VacationOrder> getAll();

    VacationOrder getById(Long id);

    VacationOrder update(Long id, VacationOrderRequest dto);

    void delete(Long id);

    VacationOrderResponse toDTO(VacationOrder vacationOrder);

    Path print(Long id);

}
