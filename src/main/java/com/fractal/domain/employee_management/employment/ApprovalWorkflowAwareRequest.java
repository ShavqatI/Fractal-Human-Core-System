package com.fractal.domain.employee_management.employment;

import org.springframework.web.bind.annotation.PathVariable;

public record ApprovalWorkflowAwareRequest (Long employeeId,Long id){
}
