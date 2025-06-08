package com.fractal.controller.organization_management.organization;

import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.address.OrganizationAddressService;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
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

    private final OrganizationService organizationService;
    private final OrganizationAddressService addressService;

    @PostMapping("")
    public ResponseEntity<OrganizationResponse> create(@PathVariable Long organizationId, @RequestBody @Valid OrganizationAddressRequest dto) {
        return new ResponseEntity<>(organizationService.toDTO(organizationService.addAddress(organizationId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationResponse> update(@PathVariable Long organizationId, @PathVariable Long id, @RequestBody @Valid OrganizationAddressRequest dto) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.updateAddress(organizationId,id, dto)));
    }

    @GetMapping
    public ResponseEntity<List<OrganizationAddressResponse>> getAll(@PathVariable Long organizationId) {
        return ResponseEntity.ok(addressService.getByOrganizationId(organizationId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long organizationId, @PathVariable Long id) {
        organizationService.deleteAddress(organizationId,id);
        return ResponseEntity.noContent().build();
    }

}
