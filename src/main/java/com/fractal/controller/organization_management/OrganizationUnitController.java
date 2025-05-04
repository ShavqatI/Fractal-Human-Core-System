package com.fractal.controller.organization_management;


import com.fractal.domain.organization_management.unit.OrganizationUnitService;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitRequest;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/organization-unit")
@RequiredArgsConstructor
public class OrganizationUnitController {

    private final OrganizationUnitService organizationUnitService;

    @PostMapping
    public ResponseEntity<OrganizationUnitResponse> create(@RequestBody @Valid OrganizationUnitRequest dto) {
        return new ResponseEntity<>(organizationUnitService.toDTO(organizationUnitService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationUnitResponse>> getAll() {
        return ResponseEntity.ok(organizationUnitService.getAll().stream().map(organizationUnitService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationUnitResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationUnitService.toDTO(organizationUnitService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<OrganizationUnitResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(organizationUnitService.toDTO(organizationUnitService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationUnitResponse> update(@PathVariable Long id, @RequestBody @Valid OrganizationUnitRequest dto) {
        return ResponseEntity.ok(organizationUnitService.toDTO(organizationUnitService.update(id,dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationUnitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
