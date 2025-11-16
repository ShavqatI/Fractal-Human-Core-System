package com.fractal.controller.employment;

import com.fractal.domain.employment.separation_reason.SeparationReasonService;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employment/{employmentId}/separation-reason")
@RequiredArgsConstructor
public class SeparationReasonController {

    private final SeparationReasonService separationReasonService;

    @PostMapping()
    public ResponseEntity<SeparationReasonResponse> create(@PathVariable Long employmentId, @RequestBody @Valid SeparationReasonRequest dto) {
        return new ResponseEntity<>(separationReasonService.toDTO(separationReasonService.create(employmentId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SeparationReasonResponse>> getAll(@PathVariable Long employmentId) {
        return ResponseEntity.ok(separationReasonService.getAllByEmploymentId(employmentId).stream().map(separationReasonService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeparationReasonResponse> getById(@PathVariable Long employmentId, @PathVariable Long id) {
        return ResponseEntity.ok(separationReasonService.toDTO(separationReasonService.getById(employmentId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeparationReasonResponse> update(@PathVariable Long employmentId, @PathVariable Long id, @RequestBody @Valid SeparationReasonRequest dto) {
        return ResponseEntity.ok(separationReasonService.toDTO(separationReasonService.update(employmentId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employmentId, @PathVariable Long id) {
        separationReasonService.delete(employmentId, id);
        return ResponseEntity.noContent().build();
    }


}