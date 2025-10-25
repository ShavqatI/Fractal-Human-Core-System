package com.fractal.controller.organization_management.organization;

import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationResponse> create(@RequestBody @Valid OrganizationRequest dto) {
        return new ResponseEntity<>(organizationService.toDTO(organizationService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> getAll() {
        return ResponseEntity.ok(organizationService.getAll().stream().map(organizationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("top-level")
    public ResponseEntity<List<OrganizationResponse>> getAllToplevel() {
        return ResponseEntity.ok(organizationService.getAllToplevel().stream().map(organizationService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.getById(id)));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<OrganizationCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(organizationService.getAll().stream().map(organizationService::toCompactDTO).collect(Collectors.toList()));
    }
    @GetMapping("/compact/{id}")
    public ResponseEntity<OrganizationCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.toCompactDTO(organizationService.getById(id)));}


    @GetMapping("/code/{code}")
    public ResponseEntity<OrganizationResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationResponse> update(@PathVariable Long id, @RequestBody @Valid OrganizationRequest dto) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.update(id, dto)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
