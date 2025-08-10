package com.fractal.controller.organization_management.organization;

import com.fractal.domain.organization_management.organization.address.OrganizationAddressService;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/organization/{organizationId}/address")
@RequiredArgsConstructor
public class OrganizationAddressController {

    private final OrganizationAddressService addressService;

    @PostMapping()
    public ResponseEntity<OrganizationAddressResponse> create(@PathVariable Long organizationId, @RequestBody @Valid OrganizationAddressRequest dto) {
        return new ResponseEntity<>(addressService.toDTO(addressService.create(organizationId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<OrganizationAddressResponse>> getAll(@PathVariable Long organizationId) {
        return ResponseEntity.ok(addressService.getAllByOrganizationId(organizationId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationAddressResponse> getById(@PathVariable Long organizationId, @PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(organizationId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationAddressResponse> update(@PathVariable Long organizationId, @PathVariable Long id, @RequestBody @Valid OrganizationAddressRequest dto) {
        return ResponseEntity.ok(addressService.toDTO(addressService.update(organizationId,id, dto)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long organizationId, @PathVariable Long id) {
        addressService.delete(organizationId,id);
        return ResponseEntity.noContent().build();
    }

}
