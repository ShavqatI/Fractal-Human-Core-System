
package com.fractal.controller.employee_management.insurance;

import com.fractal.domain.employee_management.insurance.coverage.InsuranceCoverageService;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageRequest;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/insurance{insuranceId}/coverage")
@RequiredArgsConstructor
public class InsuranceCoverageController {

    private final InsuranceCoverageService insuranceCoverageService;

    @PostMapping()
    public ResponseEntity<InsuranceCoverageResponse> create(@PathVariable Long insuranceId, @RequestBody @Valid InsuranceCoverageRequest dto) {
        return new ResponseEntity<>(insuranceCoverageService.toDTO(insuranceCoverageService.create(insuranceId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InsuranceCoverageResponse>> getAll(@PathVariable Long insuranceId) {
        return ResponseEntity.ok(insuranceCoverageService.getAllByInsuranceId(insuranceId).stream().map(insuranceCoverageService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceCoverageResponse> getById(@PathVariable Long insuranceId, @PathVariable Long id) {
        return ResponseEntity.ok(insuranceCoverageService.toDTO(insuranceCoverageService.getById(insuranceId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceCoverageResponse> update(@PathVariable Long insuranceId, @PathVariable Long id, @RequestBody @Valid InsuranceCoverageRequest dto) {
        return ResponseEntity.ok(insuranceCoverageService.toDTO(insuranceCoverageService.update(insuranceId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long insuranceId, @PathVariable Long id) {
        insuranceCoverageService.delete(insuranceId,id);
        return ResponseEntity.noContent().build();
    }


}