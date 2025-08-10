package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityRequest;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityResponse;
import com.fractal.domain.organization_management.job_description.authority.AuthorityService;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityRequest;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/job-description/{jobDescriptionId}/authority")
@RequiredArgsConstructor
public class JobDescriptionAuthorityController {

    private final AuthorityService authorityService;

    @PostMapping()
    public ResponseEntity<AuthorityResponse> create(@PathVariable Long jobDescriptionId, @RequestBody @Valid AuthorityRequest dto) {
        return new ResponseEntity<>(authorityService.toDTO(authorityService.create(jobDescriptionId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorityResponse>> getAll(@PathVariable Long jobDescriptionId) {
        return ResponseEntity.ok(authorityService.getAllByJobDescriptionId(jobDescriptionId).stream().map(authorityService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorityResponse> getById(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        return ResponseEntity.ok(authorityService.toDTO(authorityService.getById(jobDescriptionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorityResponse> update(@PathVariable Long jobDescriptionId, @PathVariable Long id, @RequestBody @Valid AuthorityRequest dto) {
        return ResponseEntity.ok(authorityService.toDTO(authorityService.update(jobDescriptionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId,@PathVariable Long id) {
        authorityService.delete(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }

}
