package com.fractal.controller.organization_management.organization_unit;


import com.fractal.domain.organization_management.organization_unit.OrganizationUnitDto;
import com.fractal.domain.organization_management.organization_unit.OrganizationUnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organization-management/organization-unit")
@RequiredArgsConstructor
public class OrganizationUnitController {

    private final OrganizationUnitService organizationUnitService;

    @PostMapping
    public ResponseEntity<OrganizationUnitDto> create(@RequestBody @Valid OrganizationUnitDto dto) {
        return new ResponseEntity<>(organizationUnitService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationUnitDto>> getAll() {
        return ResponseEntity.ok(organizationUnitService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationUnitDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationUnitService.getById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<OrganizationUnitDto> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(organizationUnitService.getByCode(code));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationUnitDto> update(@PathVariable Long id, @RequestBody @Valid OrganizationUnitDto dto) {
        return ResponseEntity.ok(organizationUnitService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationUnitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
