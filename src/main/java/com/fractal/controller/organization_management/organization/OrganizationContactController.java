package com.fractal.controller.organization_management.organization;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.organization_management.organization.contact.OrganizationContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/organization/{organizationId}/contact")
@RequiredArgsConstructor
public class OrganizationContactController {

    private final OrganizationContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactResponse> create(@PathVariable Long organizationId, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(contactService.toDTO(contactService.create(organizationId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(@PathVariable Long organizationId) {
        return ResponseEntity.ok(contactService.getAllByOrganizationId(organizationId).stream().map(contactService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable Long organizationId,@PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(organizationId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable Long organizationId, @PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(contactService.toDTO(contactService.update(organizationId,id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long organizationId, @PathVariable Long id) {
        contactService.delete(organizationId,id);
        return ResponseEntity.noContent().build();
    }

}
