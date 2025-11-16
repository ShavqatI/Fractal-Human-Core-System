package com.fractal.domain.vacation_management.vacation.order;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderApprovalWorkflowAwareRequest;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderRequest;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderResponse;

import java.util.List;

public interface VacationOrderService extends ApprovalWorkflowAware<VacationOrderApprovalWorkflowAwareRequest, VacationOrder> {

    VacationOrder create(Long vacationId, VacationOrderRequest dto);

    List<VacationOrder> getAllByVacationId(Long vacationId);

    VacationOrder getById(Long vacationId, Long id);

    VacationOrder update(Long vacationId, Long id, VacationOrderRequest dto);

    void delete(Long vacationId, Long id);

    VacationOrderResponse toDTO(VacationOrder vacationOrder);

}
