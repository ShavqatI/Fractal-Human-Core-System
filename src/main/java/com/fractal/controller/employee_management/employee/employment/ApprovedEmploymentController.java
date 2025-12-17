package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/employment/approved")
@RequiredArgsConstructor
public class ApprovedEmploymentController {

    private final EmployeeEmploymentService employmentService;

    @GetMapping()
    public ResponseEntity<List<InternalEmploymentApprovedResponse>> getAll() {
        return ResponseEntity.ok(employmentService.getAllApproved().stream().map(employmentService::toApprovedDTO).collect(Collectors.toList()));
    }
}
