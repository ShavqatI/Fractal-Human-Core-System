package com.fractal.controller.employee_management.insurance;


import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.contact.EmployeeContactService;
import com.fractal.domain.insurance.provider.contact.InsuranceProviderContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/insurance/provider/{providerId}/contact")
@RequiredArgsConstructor
public class InsuranceProviderContactController {

    private final InsuranceProviderContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactResponse> create(@PathVariable Long providerId, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(contactService.toDTO(contactService.create(providerId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(@PathVariable Long providerId) {
        return ResponseEntity.ok(contactService.getAllByInsuranceProviderId(providerId).stream().map(contactService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable Long providerId, @PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(providerId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable Long providerId, @PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(contactService.toDTO(contactService.update(providerId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long providerId, @PathVariable Long id) {
        contactService.delete(providerId,id);
        return ResponseEntity.noContent().build();
    }


}
