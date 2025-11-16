package com.fractal.controller.contact;


import com.fractal.domain.contact.type.ContactTypeService;
import com.fractal.domain.contact.type.dto.ContactTypeRequest;
import com.fractal.domain.contact.type.dto.ContactTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/contact/type")
@RequiredArgsConstructor
public class ContactTypeController {

    private final ContactTypeService contactTypeService;

    @PostMapping
    public ResponseEntity<ContactTypeResponse> create(@RequestBody @Valid ContactTypeRequest dto) {
        return new ResponseEntity<>(contactTypeService.toDTO(contactTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactTypeResponse>> getAll() {
        return ResponseEntity.ok(contactTypeService.getAll().stream().map(contactTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contactTypeService.toDTO(contactTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ContactTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(contactTypeService.toDTO(contactTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactTypeResponse> update(@PathVariable Long id, @RequestBody @Valid ContactTypeRequest dto) {
        return ResponseEntity.ok(contactTypeService.toDTO(contactTypeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contactTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
