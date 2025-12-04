package com.fractal.domain.employment;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;

public interface EmploymentService extends ApprovalWorkflowAware<Long, Employment> {
    Employment getById(Long id);
    Employment save(Employment employment);
}
