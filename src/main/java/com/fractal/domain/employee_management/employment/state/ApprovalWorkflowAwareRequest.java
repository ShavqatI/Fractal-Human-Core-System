package com.fractal.domain.employee_management.employment.state;

import org.springframework.web.bind.annotation.PathVariable;

public record ApprovalWorkflowAwareRequest (Long employeeId,Long id){
}
