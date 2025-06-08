package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
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

    private final JobDescriptionService jobDescriptionService;

    @PostMapping("/{id}/required-experience")
    public ResponseEntity<JobDescriptionResponse> create(@PathVariable Long jobDescriptionId,@RequestBody @Valid RequiredExperienceRequest dto) {
        return new ResponseEntity<>(jobDescriptionService.toDTO(jobDescriptionService.addRequiredExperience(jobDescriptionId,dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long jobDescriptionId,@PathVariable Long id, @RequestBody @Valid RequiredExperienceRequest dto) {
        jobDescriptionService.updateRequiredExperience(jobDescriptionId, id, dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        jobDescriptionService.deleteRequiredExperience(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }



}
