package com.fractal.controller.organization_management.grade.hay;


import com.fractal.domain.organization_management.grade.method.hay.factor.type.HayFactorTypeService;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grading/hay/factor/type")
@RequiredArgsConstructor
public class HayFactorTypeController {

    private final HayFactorTypeService factorTypeService;
    @PostMapping
    public ResponseEntity<HayFactorTypeResponse> create(@RequestBody @Valid HayFactorTypeRequest dto) {
        return new ResponseEntity<>(factorTypeService.toDTO(factorTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<HayFactorTypeResponse>> getAll() {
        return ResponseEntity.ok(factorTypeService.getAll().stream().map(factorTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<HayFactorTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(factorTypeService.toDTO(factorTypeService.getById(id)));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<HayFactorTypeCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(factorTypeService.getAll().stream().map(factorTypeService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<HayFactorTypeCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(factorTypeService.toCompactDTO(factorTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<HayFactorTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(factorTypeService.toDTO(factorTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<HayFactorTypeResponse> update(@PathVariable Long id, @RequestBody @Valid HayFactorTypeRequest dto) {
      return  ResponseEntity.ok(factorTypeService.toDTO(factorTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        factorTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
