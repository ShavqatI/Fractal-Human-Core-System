package com.fractal.controller.employment;

import com.fractal.domain.employment.separation_reason_type.SeparationReasonTypeService;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeCompactResponse;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeRequest;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employment/separation-reason-type")
@RequiredArgsConstructor
public class SeparationReasonTypeController {

    private final SeparationReasonTypeService separationReasonTypeService;


    @PostMapping
    public ResponseEntity<SeparationReasonTypeResponse> create(@RequestBody @Valid SeparationReasonTypeRequest dto) {
        return new ResponseEntity<>(separationReasonTypeService.toDTO(separationReasonTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<SeparationReasonTypeResponse>> getAll() {
        return ResponseEntity.ok(separationReasonTypeService.getAll().stream().map(separationReasonTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SeparationReasonTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(separationReasonTypeService.toDTO(separationReasonTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<SeparationReasonTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(separationReasonTypeService.toDTO(separationReasonTypeService.getByCode(code)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<SeparationReasonTypeCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(separationReasonTypeService.getAll().stream().map(separationReasonTypeService::toCompactDTO).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SeparationReasonTypeResponse> update(@PathVariable Long id, @RequestBody @Valid SeparationReasonTypeRequest dto) {
      return  ResponseEntity.ok(separationReasonTypeService.toDTO(separationReasonTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        separationReasonTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
