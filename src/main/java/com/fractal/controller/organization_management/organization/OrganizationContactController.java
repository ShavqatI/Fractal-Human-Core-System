package com.fractal.controller.organization_management.organization;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organization-management/organization/{organizationId}/contact")
@RequiredArgsConstructor
public class OrganizationContactController {

    private final OrganizationService organizationService;

    @PostMapping()
    public ResponseEntity<OrganizationResponse> addContact(@PathVariable Long organizationId, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(organizationService.toDTO(organizationService.addContact(organizationId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{contactId}")
    public ResponseEntity<OrganizationResponse> updateContact(@PathVariable Long organizationId, @PathVariable Long contactId, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(organizationService.toDTO(organizationService.updateContact(organizationId,contactId, dto)));
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long organizationId, @PathVariable Long contactId) {
        organizationService.deleteContact(organizationId,contactId);
        return ResponseEntity.noContent().build();
    }

}
