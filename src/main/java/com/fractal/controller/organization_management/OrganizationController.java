package com.fractal.controller.organization_management;

import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.dto.OrganizationCreate;
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
    public ResponseEntity<OrganizationResponse> create(@RequestBody @Valid OrganizationCreate dto) {
        return new ResponseEntity<>(organizationService.toDTO(organizationService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> getAll() {
        return ResponseEntity.ok(organizationService.getAll().stream().map(organizationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<OrganizationResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationResponse> update(@PathVariable Long id, @RequestBody @Valid OrganizationCreate dto) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
