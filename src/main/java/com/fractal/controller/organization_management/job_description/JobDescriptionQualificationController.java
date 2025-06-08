package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/job-description/{jobDescriptionId}/qualification")
@RequiredArgsConstructor
public class JobDescriptionQualificationController {

    private final JobDescriptionService jobDescriptionService;

    @PostMapping("/{id}/qualification")
    public ResponseEntity<JobDescriptionResponse> create(@PathVariable Long jobDescriptionId,@RequestBody @Valid QualificationRequest dto) {
        return new ResponseEntity<>(jobDescriptionService.toDTO(jobDescriptionService.addQualification(jobDescriptionId,dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long jobDescriptionId,@PathVariable Long id, @RequestBody @Valid QualificationRequest dto) {
        jobDescriptionService.updateQualification(jobDescriptionId, id, dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        jobDescriptionService.deleteQualification(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }

}
