package com.fractal.controller.organization_management;

import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
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

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.getById(id)));
    }

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

    @PutMapping("/{id}/address")
    public ResponseEntity<OrganizationResponse> addAddress(@PathVariable Long id, @RequestBody @Valid OrganizationAddressRequest dto) {
        return new ResponseEntity<>(organizationService.toDTO(organizationService.addAddress(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/address/{addressId}")
    public ResponseEntity<OrganizationResponse> updateAddress(@PathVariable Long id, @PathVariable Long addressId, @RequestBody @Valid OrganizationAddressRequest dto) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.updateAddress(id,addressId, dto)));
    }

    @DeleteMapping("/{id}/address/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id, @PathVariable Long addressId) {
        organizationService.deleteAddress(id,addressId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/child")
    public ResponseEntity<OrganizationResponse> addAddress(@PathVariable Long id, @RequestBody @Valid OrganizationRequest dto) {
        return new ResponseEntity<>(organizationService.toDTO(organizationService.addChild(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/child/{childId}")
    public ResponseEntity<OrganizationResponse> addAddress(@PathVariable Long id, @PathVariable Long childId, @RequestBody @Valid OrganizationRequest dto) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.updateChild(id,childId, dto)));
    }

    @DeleteMapping("/{id}/child/{childId}")
    public ResponseEntity<Void> deleteChild(@PathVariable Long id, @PathVariable Long childId) {
        organizationService.deleteChild(id,childId);
        return ResponseEntity.noContent().build();
    }
}
