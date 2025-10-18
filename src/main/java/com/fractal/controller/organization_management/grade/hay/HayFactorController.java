package com.fractal.controller.organization_management.grade.hay;


import com.fractal.domain.organization_management.grade.method.hay.factor.HayFactorService;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grading/hay/factor")
@RequiredArgsConstructor
public class HayFactorController {

    private final HayFactorService factorService;
    @PostMapping
    public ResponseEntity<HayFactorResponse> create(@RequestBody @Valid HayFactorRequest dto) {
        return new ResponseEntity<>(factorService.toDTO(factorService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<HayFactorResponse>> getAll() {
        return ResponseEntity.ok(factorService.getAll().stream().map(factorService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<HayFactorResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(factorService.toDTO(factorService.getById(id)));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<HayFactorCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(factorService.getAll().stream().map(factorService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<HayFactorCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(factorService.toCompactDTO(factorService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<HayFactorResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(factorService.toDTO(factorService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<HayFactorResponse> update(@PathVariable Long id, @RequestBody @Valid HayFactorRequest dto) {
      return  ResponseEntity.ok(factorService.toDTO(factorService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        factorService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
