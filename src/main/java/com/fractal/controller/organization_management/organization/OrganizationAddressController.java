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
    public ResponseEntity<OrganizationResponse> addAddress(@PathVariable Long organizationId, @RequestBody @Valid OrganizationAddressRequest dto) {
        return new ResponseEntity<>(organizationService.toDTO(organizationService.addAddress(organizationId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{addressId}")
    public ResponseEntity<OrganizationResponse> updateAddress(@PathVariable Long organizationId, @PathVariable Long addressId, @RequestBody @Valid OrganizationAddressRequest dto) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.updateAddress(organizationId,addressId, dto)));
    }

    @GetMapping
    public ResponseEntity<List<OrganizationAddressResponse>> getAll(@PathVariable Long organizationId) {
        return ResponseEntity.ok(addressService.getByOrganizationId(organizationId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }

    @DeleteMapping("{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long organizationId, @PathVariable Long addressId) {
        organizationService.deleteAddress(organizationId,addressId);
        return ResponseEntity.noContent().build();
    }

}
