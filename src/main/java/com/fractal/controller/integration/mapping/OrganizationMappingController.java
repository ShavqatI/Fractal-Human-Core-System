package com.fractal.controller.integration.mapping;

import com.fractal.domain.integration.mapping.organization.OrganizationMappingService;
import com.fractal.domain.integration.mapping.organization.dto.OrganizationMappingRequest;
import com.fractal.domain.integration.mapping.organization.dto.OrganizationMappingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/integration/mapping/organization")
@RequiredArgsConstructor
public class OrganizationMappingController {

    private final OrganizationMappingService organizationMappingService;


    @PostMapping
    public ResponseEntity<OrganizationMappingResponse> create(@RequestBody @Valid OrganizationMappingRequest dto) {
        return new ResponseEntity<>(organizationMappingService.toDTO(organizationMappingService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationMappingResponse>> getAll() {
        return ResponseEntity.ok(organizationMappingService.getAll().stream().map(organizationMappingService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationMappingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationMappingService.toDTO(organizationMappingService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationMappingResponse> update(@PathVariable Long id, @RequestBody @Valid OrganizationMappingRequest dto) {
        return ResponseEntity.ok(organizationMappingService.toDTO(organizationMappingService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationMappingService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
