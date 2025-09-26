package com.fractal.controller.learning_develpment.learning.learner;


import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.contact.ExternalLearnerContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/learner/external/{learnerId}/contact")
@RequiredArgsConstructor
public class ExternalLearnerContactController {

    private final ExternalLearnerContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactResponse> create(@PathVariable Long learnerId, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(contactService.toDTO(contactService.create(learnerId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(@PathVariable Long learnerId) {
        return ResponseEntity.ok(contactService.getAllByExternalLearnerId(learnerId).stream().map(contactService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable Long learnerId, @PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(learnerId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable Long learnerId, @PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(contactService.toDTO(contactService.update(learnerId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long learnerId, @PathVariable Long id) {
        contactService.delete(learnerId,id);
        return ResponseEntity.noContent().build();
    }


}
