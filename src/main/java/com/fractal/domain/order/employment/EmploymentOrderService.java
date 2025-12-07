package com.fractal.domain.order.employment;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.order.employment.dto.*;

import java.nio.file.Path;
import java.util.List;

public interface EmploymentOrderService extends ApprovalWorkflowAware<Long, EmploymentOrder> {

    EmploymentOrder create(EmploymentOrderRequest dto);

    List<EmploymentOrder> getAll();

    EmploymentOrder getById(Long id);

    EmploymentOrder update(Long id, EmploymentOrderRequest dto);

    void delete(Long id);

    EmploymentOrderResponse toDTO(EmploymentOrder employmentOrder);

    EmploymentOrder save(EmploymentOrder order);

    Path print(Long id);

    EmploymentOrder hire(EmploymentOrderHireRequest dto);
    EmploymentOrder terminate(EmploymentOrderTerminationRequest dto);
    EmploymentOrder transfer(EmploymentOrderTransferRequest dto);


}
