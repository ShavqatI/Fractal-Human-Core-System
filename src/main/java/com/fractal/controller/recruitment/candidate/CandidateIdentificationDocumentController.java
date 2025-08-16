package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/identification-document")
@RequiredArgsConstructor
public class CandidateIdentificationDocumentController {

    private final CandidateIdentificationDocumentService identificationDocumentService;

    @PostMapping()
    public ResponseEntity<IdentificationDocumentResponse> create(@PathVariable Long candidateId, @RequestBody @Valid IdentificationDocumentRequest dto) {
        return new ResponseEntity<>(identificationDocumentService.toDTO(identificationDocumentService.create(candidateId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<IdentificationDocumentResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(identificationDocumentService.getAllByCandidateId(candidateId).stream().map(identificationDocumentService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<IdentificationDocumentResponse> getById(@PathVariable Long candidateId,@PathVariable Long id) {
        return ResponseEntity.ok(identificationDocumentService.toDTO(identificationDocumentService.getById(candidateId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<IdentificationDocumentResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid IdentificationDocumentRequest dto) {
        return ResponseEntity.ok(identificationDocumentService.toDTO(identificationDocumentService.update(candidateId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        identificationDocumentService.delete(candidateId,id);
        return ResponseEntity.noContent().build();
    }



}
