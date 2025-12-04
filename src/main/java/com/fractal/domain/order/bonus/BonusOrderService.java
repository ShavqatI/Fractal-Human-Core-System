package com.fractal.domain.order.bonus;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.order.bonus.dto.EmploymentOrderRequest;
import com.fractal.domain.order.bonus.dto.BonusOrderResponse;

import java.nio.file.Path;
import java.util.List;

public interface BonusOrderService extends ApprovalWorkflowAware<Long, BonusOrder> {

    BonusOrder create(EmploymentOrderRequest dto);

    List<BonusOrder> getAll();

    BonusOrder getById(Long id);

    BonusOrder update(Long id, EmploymentOrderRequest dto);

    void delete(Long id);

    BonusOrderResponse toDTO(BonusOrder bonusOrder);

    BonusOrder save(BonusOrder order);

    Path print(Long id);
}
