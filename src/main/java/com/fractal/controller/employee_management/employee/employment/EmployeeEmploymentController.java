package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/employment")
@RequiredArgsConstructor
public class EmployeeEmploymentController {

    private final EmployeeEmploymentService employmentService;

    @PostMapping()
    public ResponseEntity<EmploymentResponse> create(@PathVariable Long employeeId, @RequestBody @Valid EmploymentRequest dto) {
        return new ResponseEntity<>(employmentService.toDTO(employmentService.create(employeeId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employmentService.getAllByEmployeeId(employeeId).stream().map(employmentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentResponse> getById(@PathVariable Long employeeId, @PathVariable Long id) {
        return ResponseEntity.ok(employmentService.toDTO(employmentService.getById(employeeId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EmploymentRequest dto) {
        return ResponseEntity.ok(employmentService.toDTO(employmentService.update(employeeId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        employmentService.delete(employeeId, id);
        return ResponseEntity.noContent().build();
    }

}
