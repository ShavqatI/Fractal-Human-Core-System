package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.qualification.QualificationService;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
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

    private final QualificationService qualificationService;

    @PostMapping()
    public ResponseEntity<QualificationResponse> create(@PathVariable Long jobDescriptionId, @RequestBody @Valid QualificationRequest dto) {
        return new ResponseEntity<>(qualificationService.toDTO(qualificationService.create(jobDescriptionId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QualificationResponse>> getAll(@PathVariable Long jobDescriptionId) {
        return ResponseEntity.ok(qualificationService.getAllByJobDescriptionId(jobDescriptionId).stream().map(qualificationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualificationResponse> getById(@PathVariable Long jobDescriptionId, @PathVariable Long id) {
        return ResponseEntity.ok(qualificationService.toDTO(qualificationService.getById(jobDescriptionId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QualificationResponse> update(@PathVariable Long jobDescriptionId, @PathVariable Long id, @RequestBody @Valid QualificationRequest dto) {
        return ResponseEntity.ok(qualificationService.toDTO(qualificationService.update(jobDescriptionId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId, @PathVariable Long id) {
        qualificationService.delete(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }

}
