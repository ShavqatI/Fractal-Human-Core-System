package com.fractal.controller.employee_management.employee;


import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.contact.EmployeeContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/contact")
@RequiredArgsConstructor
public class EmployeeContactController {

    private final EmployeeContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactResponse> create(@PathVariable Long employeeId, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(contactService.toDTO(contactService.create(employeeId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(contactService.getAllByEmployeeId(employeeId).stream().map(contactService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable Long employeeId, @PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(employeeId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(contactService.toDTO(contactService.update(employeeId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        contactService.delete(employeeId, id);
        return ResponseEntity.noContent().build();
    }


}
