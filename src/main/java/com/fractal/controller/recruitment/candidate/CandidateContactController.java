package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.recruitment.candidate.contact.CandidateContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/contact")
@RequiredArgsConstructor
public class CandidateContactController {

    private final CandidateContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactResponse> create(@PathVariable Long candidateId, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(contactService.toDTO(contactService.create(candidateId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(contactService.getAllByCandidateId(candidateId).stream().map(contactService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable Long candidateId,@PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(candidateId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(contactService.toDTO(contactService.update(candidateId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        contactService.delete(candidateId,id);
        return ResponseEntity.noContent().build();
    }


}
