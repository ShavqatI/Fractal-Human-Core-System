package com.fractal.controller.insurance;


import com.fractal.domain.insurance.type.InsuranceTypeService;
import com.fractal.domain.insurance.type.dto.InsuranceTypeRequest;
import com.fractal.domain.insurance.type.dto.InsuranceTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/insurance/type")
@RequiredArgsConstructor
public class InsuranceTypeController {

    private final InsuranceTypeService insuranceTypeService;
    @PostMapping
    public ResponseEntity<InsuranceTypeResponse> create(@RequestBody @Valid InsuranceTypeRequest dto) {
        return new ResponseEntity<>(insuranceTypeService.toDTO(insuranceTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InsuranceTypeResponse>> getAll() {
        return ResponseEntity.ok(insuranceTypeService.getAll().stream().map(insuranceTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(insuranceTypeService.toDTO(insuranceTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<InsuranceTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(insuranceTypeService.toDTO(insuranceTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceTypeResponse> update(@PathVariable Long id, @RequestBody @Valid InsuranceTypeRequest dto) {
      return  ResponseEntity.ok(insuranceTypeService.toDTO(insuranceTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        insuranceTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
