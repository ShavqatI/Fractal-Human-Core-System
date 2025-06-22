package com.fractal.controller.employee_management.employee.relative;


import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.relative.contact.RelativeContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/relative/{relativeId}/contact")
@RequiredArgsConstructor
public class EmployeeRelativeContactController {

    private final RelativeContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactResponse> create(@PathVariable Long relativeId, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(contactService.toDTO(contactService.create(relativeId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(@PathVariable Long relativeId) {
        return ResponseEntity.ok(contactService.getAllByRelativeId(relativeId).stream().map(contactService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable Long relativeId,@PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(relativeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable Long relativeId, @PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(contactService.toDTO(contactService.update(relativeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long relativeId, @PathVariable Long id) {
        contactService.delete(relativeId,id);
        return ResponseEntity.noContent().build();
    }


}
