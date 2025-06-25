package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.required_experience.RequiredExperienceService;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/job-description/{jobDescriptionId}/required-experience")
@RequiredArgsConstructor
public class JobDescriptionRequiredExperienceController {

    private final RequiredExperienceService requiredExperienceService;

    @PostMapping("/{id}/required-experience")
    public ResponseEntity<RequiredExperienceResponse> create(@PathVariable Long jobDescriptionId, @RequestBody @Valid RequiredExperienceRequest dto) {
        return new ResponseEntity<>(requiredExperienceService.toDTO(requiredExperienceService.create(jobDescriptionId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RequiredExperienceResponse>> getAll(@PathVariable Long jobDescriptionId) {
        return ResponseEntity.ok(requiredExperienceService.getAllByJobDescriptionId(jobDescriptionId).stream().map(requiredExperienceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RequiredExperienceResponse> getById(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        return ResponseEntity.ok(requiredExperienceService.toDTO(requiredExperienceService.getById(jobDescriptionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequiredExperienceResponse> update(@PathVariable Long jobDescriptionId, @PathVariable Long id, @RequestBody @Valid RequiredExperienceRequest dto) {
        return ResponseEntity.ok(requiredExperienceService.toDTO(requiredExperienceService.update(jobDescriptionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        requiredExperienceService.delete(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }



}
