package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employee_management.employment.EmploymentHistoryService;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/employment-history")
@RequiredArgsConstructor
public class EmployeeEmploymentHistoryController {

    private final EmploymentHistoryService employmentHistoryService;

    @PostMapping()
    public ResponseEntity<EmploymentHistoryResponse> create(@PathVariable Long employeeId, @RequestBody @Valid EmploymentHistoryRequest dto) {
        return new ResponseEntity<>(employmentHistoryService.toDTO(employmentHistoryService.create(employeeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmploymentHistoryResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employmentHistoryService.getAllByEmployeeId(employeeId).stream().map(employmentHistoryService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentHistoryResponse> getById(@PathVariable Long employeeId,@PathVariable Long id) {
        return ResponseEntity.ok(employmentHistoryService.toDTO(employmentHistoryService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentHistoryResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EmploymentHistoryRequest dto) {
        return ResponseEntity.ok(employmentHistoryService.toDTO(employmentHistoryService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        employmentHistoryService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }

}
