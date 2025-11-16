package com.fractal.controller.employment;

import com.fractal.domain.employment.internal.compensation_component.CompensationComponentService;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employment/{employmentId}/compensation-component")
@RequiredArgsConstructor
public class CompensationComponentController {

    private final CompensationComponentService compensationComponentService;

    @PostMapping()
    public ResponseEntity<CompensationComponentResponse> create(@PathVariable Long employmentId, @RequestBody @Valid CompensationComponentRequest dto) {
        return new ResponseEntity<>(compensationComponentService.toDTO(compensationComponentService.create(employmentId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CompensationComponentResponse>> getAll(@PathVariable Long employmentId) {
        return ResponseEntity.ok(compensationComponentService.getAllByInternalEmploymentId(employmentId).stream().map(compensationComponentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompensationComponentResponse> getById(@PathVariable Long employmentId, @PathVariable Long id) {
        return ResponseEntity.ok(compensationComponentService.toDTO(compensationComponentService.getById(employmentId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompensationComponentResponse> update(@PathVariable Long employmentId, @PathVariable Long id, @RequestBody @Valid CompensationComponentRequest dto) {
        return ResponseEntity.ok(compensationComponentService.toDTO(compensationComponentService.update(employmentId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employmentId, @PathVariable Long id) {
        compensationComponentService.delete(employmentId, id);
        return ResponseEntity.noContent().build();
    }


}