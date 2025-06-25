package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.responsibility.ResponsibilityService;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/job-description/{jobDescriptionId}/responsibility")
@RequiredArgsConstructor
public class JobDescriptionResponsibilityController {

    private final ResponsibilityService responsibilityService;

    @PostMapping()
    public ResponseEntity<ResponsibilityResponse> create(@PathVariable Long jobDescriptionId, @RequestBody @Valid ResponsibilityRequest dto) {
        return new ResponseEntity<>(responsibilityService.toDTO(responsibilityService.create(jobDescriptionId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponsibilityResponse>> getAll(@PathVariable Long jobDescriptionId) {
        return ResponseEntity.ok(responsibilityService.getAllByJobDescriptionId(jobDescriptionId).stream().map(responsibilityService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponsibilityResponse> getById(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        return ResponseEntity.ok(responsibilityService.toDTO(responsibilityService.getById(jobDescriptionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsibilityResponse> update(@PathVariable Long jobDescriptionId, @PathVariable Long id, @RequestBody @Valid ResponsibilityRequest dto) {
        return ResponseEntity.ok(responsibilityService.toDTO(responsibilityService.update(jobDescriptionId,id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        responsibilityService.delete(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }

}
