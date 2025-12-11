package com.fractal.domain.employment;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;

import java.time.LocalDate;

public interface EmploymentService extends ApprovalWorkflowAware<Long, Employment> {
    Employment getById(Long id);
    Employment save(Employment employment);

    Employment activate(Long id);

    Employment close(Long id, LocalDate endDate);
}
