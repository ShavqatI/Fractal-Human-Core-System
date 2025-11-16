package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusRequest;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/marital-status")
@RequiredArgsConstructor
public class MaritalStatusController {

    private final MaritalStatusService maritalStatusService;

    @PostMapping
    public ResponseEntity<MaritalStatusResponse> create(@RequestBody @Valid MaritalStatusRequest dto) {
        return new ResponseEntity<>(maritalStatusService.toDTO(maritalStatusService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MaritalStatusResponse>> getAll() {
        return ResponseEntity.ok(maritalStatusService.getAll().stream().map(maritalStatusService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaritalStatusResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(maritalStatusService.toDTO(maritalStatusService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<MaritalStatusResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(maritalStatusService.toDTO(maritalStatusService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaritalStatusResponse> update(@PathVariable Long id, @RequestBody @Valid MaritalStatusRequest dto) {
        return ResponseEntity.ok(maritalStatusService.toDTO(maritalStatusService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        maritalStatusService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
