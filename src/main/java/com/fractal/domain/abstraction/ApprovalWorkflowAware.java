package com.fractal.domain.abstraction;

public interface ApprovalWorkflowAware<T, R> {

    R review(T o);

    R approve(T o);
}
