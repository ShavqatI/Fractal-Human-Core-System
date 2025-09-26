package com.fractal.controller.learning_develpment.learning.instructor;


import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.contact.ExternalInstructorContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/instructor/external/{instructorId}/contact")
@RequiredArgsConstructor
public class ExternalInstructorContactController {

    private final ExternalInstructorContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactResponse> create(@PathVariable Long instructorId, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(contactService.toDTO(contactService.create(instructorId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(@PathVariable Long instructorId) {
        return ResponseEntity.ok(contactService.getAllByExternalInstructorId(instructorId).stream().map(contactService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable Long instructorId, @PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(instructorId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable Long instructorId, @PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(contactService.toDTO(contactService.update(instructorId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long instructorId, @PathVariable Long id) {
        contactService.delete(instructorId,id);
        return ResponseEntity.noContent().build();
    }


}
