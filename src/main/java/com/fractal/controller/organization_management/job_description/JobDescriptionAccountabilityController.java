package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.accountability.AccountabilityService;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityRequest;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/job-description/{jobDescriptionId}/accountability")
@RequiredArgsConstructor
public class JobDescriptionAccountabilityController {

    private final AccountabilityService accountabilityService;

    @PostMapping()
    public ResponseEntity<AccountabilityResponse> create(@PathVariable Long jobDescriptionId, @RequestBody @Valid AccountabilityRequest dto) {
        return new ResponseEntity<>(accountabilityService.toDTO(accountabilityService.create(jobDescriptionId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountabilityResponse>> getAll(@PathVariable Long jobDescriptionId) {
        return ResponseEntity.ok(accountabilityService.getAllByJobDescriptionId(jobDescriptionId).stream().map(accountabilityService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountabilityResponse> getById(@PathVariable Long jobDescriptionId, @PathVariable Long id) {
        return ResponseEntity.ok(accountabilityService.toDTO(accountabilityService.getById(jobDescriptionId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountabilityResponse> update(@PathVariable Long jobDescriptionId, @PathVariable Long id, @RequestBody @Valid AccountabilityRequest dto) {
        return ResponseEntity.ok(accountabilityService.toDTO(accountabilityService.update(jobDescriptionId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId, @PathVariable Long id) {
        accountabilityService.delete(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }

}
