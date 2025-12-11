package com.fractal.domain.employment.internal.compensation_component;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.employment.internal.compensation_component.dto.ApprovalWorkflowAwareRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentResponse;
import com.fractal.domain.order.vacation.VacationOrder;

import java.util.List;

public interface CompensationComponentService extends ApprovalWorkflowAware<ApprovalWorkflowAwareRequest, CompensationComponent> {
    CompensationComponent create(Long employmentId, CompensationComponentRequest dto);

    List<CompensationComponent> getAllByInternalEmploymentId(Long employmentId);

    CompensationComponent getById(Long employmentId, Long id);

    CompensationComponent update(Long employmentId, Long id, CompensationComponentRequest dto);

    void delete(Long employmentId, Long id);

    CompensationComponentResponse toDTO(CompensationComponent agreement);

    CompensationComponent save(CompensationComponent agreement);

    CompensationComponent getById(Long id);

    CompensationComponent activate(Long employmentId, Long id);


}
