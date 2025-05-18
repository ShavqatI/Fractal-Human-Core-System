package com.fractal.controller.organization_management;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/job-description")
@RequiredArgsConstructor
public class JobDescriptionController {

    private final JobDescriptionService jobDescriptionService;

    @PostMapping
    public ResponseEntity<JobDescriptionResponse> create(@RequestBody @Valid JobDescriptionRequest dto) {
        return new ResponseEntity<>(jobDescriptionService.toDTO(jobDescriptionService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobDescriptionResponse>> getAll() {
        return ResponseEntity.ok(jobDescriptionService.getAll().stream().map(jobDescriptionService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDescriptionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(jobDescriptionService.toDTO(jobDescriptionService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDescriptionResponse> update(@PathVariable Long id, @RequestBody @Valid JobDescriptionRequest dto) {
        return ResponseEntity.ok(jobDescriptionService.toDTO(jobDescriptionService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jobDescriptionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/responsibility")
    public ResponseEntity<JobDescriptionResponse> addResponsibility(@PathVariable Long id,@RequestBody @Valid ResponsibilityRequest dto) {
        return new ResponseEntity<>(jobDescriptionService.toDTO(jobDescriptionService.addResponsibility(id,dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/responsibility/{responsibilityId}")
    public ResponseEntity<Void> updateResponsibility(@PathVariable Long id,@PathVariable Long responsibilityId, @RequestBody @Valid ResponsibilityRequest dto) {
        jobDescriptionService.updateResponsibility(id, responsibilityId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/responsibility/{responsibilityId}")
    public ResponseEntity<Void> removeResponsibility(@PathVariable Long id,@PathVariable Long responsibilityId) {
        jobDescriptionService.removeResponsibility(id, responsibilityId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/qualification")
    public ResponseEntity<JobDescriptionResponse> addQualification(@PathVariable Long id,@RequestBody @Valid QualificationRequest dto) {
        return new ResponseEntity<>(jobDescriptionService.toDTO(jobDescriptionService.addQualification(id,dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/qualification/{qualificationId}")
    public ResponseEntity<Void> updateQualification(@PathVariable Long id,@PathVariable Long qualificationId, @RequestBody @Valid QualificationRequest dto) {
        jobDescriptionService.updateQualification(id, qualificationId, dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}/qualification/{qualificationId}")
    public ResponseEntity<Void> removeQualification(@PathVariable Long id,@PathVariable Long qualificationId) {
        jobDescriptionService.removeQualification(id, qualificationId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/required-experience")
    public ResponseEntity<JobDescriptionResponse> addRequiredExperience(@PathVariable Long id,@RequestBody @Valid RequiredExperienceRequest dto) {
        return new ResponseEntity<>(jobDescriptionService.toDTO(jobDescriptionService.addRequiredExperience(id,dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/required-experience/{requiredExperienceId}")
    public ResponseEntity<Void> updateRequiredExperience(@PathVariable Long id,@PathVariable Long requiredExperienceId, @RequestBody @Valid RequiredExperienceRequest dto) {
        jobDescriptionService.updateRequiredExperience(id, requiredExperienceId, dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}/required-experience/{requiredExperienceId}")
    public ResponseEntity<Void> removeRequiredExperience(@PathVariable Long id,@PathVariable Long experienceId) {
        jobDescriptionService.removeRequiredExperience(id, experienceId);
        return ResponseEntity.noContent().build();
    }



}
