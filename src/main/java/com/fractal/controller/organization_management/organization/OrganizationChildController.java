package com.fractal.controller.organization_management.organization;

import com.fractal.domain.organization_management.organization.OrganizationService;
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
@RequestMapping("/api/v1/organization-management/organization/{organizationId}/child")
@RequiredArgsConstructor
public class OrganizationChildController {

    private final OrganizationService organizationService;

    @PostMapping()
    public ResponseEntity<OrganizationResponse> create(@PathVariable Long organizationId, @RequestBody @Valid OrganizationRequest dto) {
        return new ResponseEntity<>(organizationService.toDTO(organizationService.addChild(organizationId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationResponse> update(@PathVariable Long organizationId, @PathVariable Long id, @RequestBody @Valid OrganizationRequest dto) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.updateChild(organizationId,id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long organizationId, @PathVariable Long id) {
        organizationService.deleteChild(organizationId,id);
        return ResponseEntity.noContent().build();
    }
}
