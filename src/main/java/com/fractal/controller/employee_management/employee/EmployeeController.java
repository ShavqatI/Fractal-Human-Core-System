package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@RequestBody @Valid EmployeeRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(employeeService.getAll().stream().map(employeeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<EmployeeCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(employeeService.getAll().stream().map(employeeService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.getById(id)));
    }

    @GetMapping("/tin/{tin}")
    public ResponseEntity<EmployeeResponse> getByTin(@PathVariable String tin) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.getByTin(tin)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @RequestBody @Valid EmployeeRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
