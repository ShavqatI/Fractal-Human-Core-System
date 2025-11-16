package com.fractal.controller.integration.mapping;

import com.fractal.domain.integration.mapping.employee.EmployeeMappingService;
import com.fractal.domain.integration.mapping.employee.dto.EmployeeMappingRequest;
import com.fractal.domain.integration.mapping.employee.dto.EmployeeMappingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/integration/mapping/employee")
@RequiredArgsConstructor
public class EmployeeMappingController {

    private final EmployeeMappingService employeeMappingService;


    @PostMapping
    public ResponseEntity<EmployeeMappingResponse> create(@RequestBody @Valid EmployeeMappingRequest dto) {
        return new ResponseEntity<>(employeeMappingService.toDTO(employeeMappingService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeMappingResponse>> getAll() {
        return ResponseEntity.ok(employeeMappingService.getAll().stream().map(employeeMappingService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeMappingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeMappingService.toDTO(employeeMappingService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeMappingResponse> update(@PathVariable Long id, @RequestBody @Valid EmployeeMappingRequest dto) {
        return ResponseEntity.ok(employeeMappingService.toDTO(employeeMappingService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeMappingService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
