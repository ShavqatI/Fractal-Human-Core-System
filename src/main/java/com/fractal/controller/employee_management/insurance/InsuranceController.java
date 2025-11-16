package com.fractal.controller.employee_management.insurance;


import com.fractal.domain.employee_management.insurance.InsuranceService;
import com.fractal.domain.employee_management.insurance.dto.InsuranceRequest;
import com.fractal.domain.employee_management.insurance.dto.InsuranceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/insurance")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping
    public ResponseEntity<InsuranceResponse> create(@RequestBody @Valid InsuranceRequest dto) {
        return new ResponseEntity<>(insuranceService.toDTO(insuranceService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InsuranceResponse>> getAll() {
        return ResponseEntity.ok(insuranceService.getAll().stream().map(insuranceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(insuranceService.toDTO(insuranceService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceResponse> update(@PathVariable Long id, @RequestBody @Valid InsuranceRequest dto) {
        return ResponseEntity.ok(insuranceService.toDTO(insuranceService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        insuranceService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
