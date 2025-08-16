package com.fractal.controller.identification_document;


import com.fractal.domain.identification_document.resource.IdentificationDocumentResourceService;
import com.fractal.domain.resource.dto.ResourceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/identification-document/{identificationDocumentId}/resource")
@RequiredArgsConstructor
public class IdentificationDocumentResourceController {

    private final IdentificationDocumentResourceService resourceService;

    @PostMapping()
    public ResponseEntity<ResourceResponse> create(@PathVariable Long identificationDocumentId, @RequestBody @Valid MultipartFile file) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(identificationDocumentId,file)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll(@PathVariable Long identificationDocumentId) {
        return ResponseEntity.ok(resourceService.getAllByIdentificationDocumentId(identificationDocumentId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable Long identificationDocumentId,@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(identificationDocumentId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResourceResponse> update(@PathVariable Long identificationDocumentId, @PathVariable Long id, @RequestBody @Valid MultipartFile file) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(identificationDocumentId,id, file)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long identificationDocumentId, @PathVariable Long id) {
        resourceService.delete(identificationDocumentId,id);
        return ResponseEntity.noContent().build();
    }



}
