package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organization-management/job-description/{jobDescriptionId}/responsibility")
@RequiredArgsConstructor
public class JobDescriptionResponsibilityController {

    private final JobDescriptionService jobDescriptionService;

    @PostMapping()
    public ResponseEntity<JobDescriptionResponse> create(@PathVariable Long jobDescriptionId,@RequestBody @Valid ResponsibilityRequest dto) {
        return new ResponseEntity<>(jobDescriptionService.toDTO(jobDescriptionService.addResponsibility(jobDescriptionId,dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long jobDescriptionId,@PathVariable Long id, @RequestBody @Valid ResponsibilityRequest dto) {
        jobDescriptionService.updateResponsibility(jobDescriptionId, id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeResponsibility(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        jobDescriptionService.deleteResponsibility(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }

}
