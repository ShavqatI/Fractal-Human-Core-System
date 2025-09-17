package com.fractal.controller.employee_management.insurance;


import com.fractal.domain.insurance.provider.InsuranceProviderService;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderCompactResponse;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderRequest;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/insurance/provider")
@RequiredArgsConstructor
public class InsuranceProviderController {

    private final InsuranceProviderService insuranceProviderService;
    @PostMapping
    public ResponseEntity<InsuranceProviderResponse> create(@RequestBody @Valid InsuranceProviderRequest dto) {
        return new ResponseEntity<>(insuranceProviderService.toDTO(insuranceProviderService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InsuranceProviderResponse>> getAll() {
        return ResponseEntity.ok(insuranceProviderService.getAll().stream().map(insuranceProviderService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceProviderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(insuranceProviderService.toDTO(insuranceProviderService.getById(id)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<InsuranceProviderCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(insuranceProviderService.getAll().stream().map(insuranceProviderService::toCompactDTO).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceProviderResponse> update(@PathVariable Long id, @RequestBody @Valid InsuranceProviderRequest dto) {
      return  ResponseEntity.ok(insuranceProviderService.toDTO(insuranceProviderService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        insuranceProviderService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
