package com.fractal.controller.profile.candidate;


import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.profile.candidate.identification_document.CandidateProfileIdentificationDocumentService;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/candidate/identification-document")
@RequiredArgsConstructor
public class CandidateProfileIdentificationDocumentController {

    private final CandidateProfileIdentificationDocumentService identificationDocumentService;

    @PostMapping()
    public ResponseEntity<IdentificationDocumentResponse> create(@RequestBody @Valid IdentificationDocumentRequest dto) {
        return new ResponseEntity<>(identificationDocumentService.toDTO(identificationDocumentService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IdentificationDocumentResponse>> getAll() {
        return ResponseEntity.ok(identificationDocumentService.getAll().stream().map(identificationDocumentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdentificationDocumentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(identificationDocumentService.toDTO(identificationDocumentService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IdentificationDocumentResponse> update(@PathVariable Long id, @RequestBody @Valid IdentificationDocumentRequest dto) {
        return ResponseEntity.ok(identificationDocumentService.toDTO(identificationDocumentService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        identificationDocumentService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
