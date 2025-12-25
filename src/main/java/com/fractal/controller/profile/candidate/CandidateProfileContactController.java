package com.fractal.controller.profile.candidate;


import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.profile.candidate.contact.CandidateProfileContactService;
import com.fractal.domain.recruitment.candidate.contact.CandidateContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/candidate/contact")
@RequiredArgsConstructor
public class CandidateProfileContactController {

    private final CandidateProfileContactService contactService;

    @PostMapping()
    public ResponseEntity<ContactResponse> create(@RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(contactService.toDTO(contactService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll() {
        return ResponseEntity.ok(contactService.getAll().stream().map(contactService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(contactService.toDTO(contactService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
