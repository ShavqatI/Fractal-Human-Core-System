package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
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

}
