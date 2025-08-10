package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityRequest;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityResponse;
import com.fractal.domain.organization_management.job_description.kpi.KeyPerformanceIndicatorService;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorRequest;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/job-description/{jobDescriptionId}/key-performance-indicator")
@RequiredArgsConstructor
public class JobDescriptionKeyPerformanceIndicatorController {

    private final KeyPerformanceIndicatorService keyPerformanceIndicatorService;

    @PostMapping()
    public ResponseEntity<KeyPerformanceIndicatorResponse> create(@PathVariable Long jobDescriptionId, @RequestBody @Valid KeyPerformanceIndicatorRequest dto) {
        return new ResponseEntity<>(keyPerformanceIndicatorService.toDTO(keyPerformanceIndicatorService.create(jobDescriptionId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<KeyPerformanceIndicatorResponse>> getAll(@PathVariable Long jobDescriptionId) {
        return ResponseEntity.ok(keyPerformanceIndicatorService.getAllByJobDescriptionId(jobDescriptionId).stream().map(keyPerformanceIndicatorService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<KeyPerformanceIndicatorResponse> getById(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        return ResponseEntity.ok(keyPerformanceIndicatorService.toDTO(keyPerformanceIndicatorService.getById(jobDescriptionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeyPerformanceIndicatorResponse> update(@PathVariable Long jobDescriptionId, @PathVariable Long id, @RequestBody @Valid KeyPerformanceIndicatorRequest dto) {
        return ResponseEntity.ok(keyPerformanceIndicatorService.toDTO(keyPerformanceIndicatorService.update(jobDescriptionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        keyPerformanceIndicatorService.delete(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }

}
