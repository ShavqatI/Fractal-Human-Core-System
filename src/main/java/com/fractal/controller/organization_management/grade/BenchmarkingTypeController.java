package com.fractal.controller.organization_management.grade;


import com.fractal.domain.organization_management.grade.benchmarking.type.BenchmarkingTypeService;
import com.fractal.domain.organization_management.grade.benchmarking.type.dto.BenchmarkingTypeRequest;
import com.fractal.domain.organization_management.grade.benchmarking.type.dto.BenchmarkingTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade/benchmarking-type")
@RequiredArgsConstructor
public class BenchmarkingTypeController {

    private final BenchmarkingTypeService benchmarkingTypeService;
    @PostMapping
    public ResponseEntity<BenchmarkingTypeResponse> create(@RequestBody @Valid BenchmarkingTypeRequest dto) {
        return new ResponseEntity<>(benchmarkingTypeService.toDTO(benchmarkingTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BenchmarkingTypeResponse>> getAll() {
        return ResponseEntity.ok(benchmarkingTypeService.getAll().stream().map(benchmarkingTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BenchmarkingTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(benchmarkingTypeService.toDTO(benchmarkingTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<BenchmarkingTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(benchmarkingTypeService.toDTO(benchmarkingTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BenchmarkingTypeResponse> update(@PathVariable Long id, @RequestBody @Valid BenchmarkingTypeRequest dto) {
      return  ResponseEntity.ok(benchmarkingTypeService.toDTO(benchmarkingTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        benchmarkingTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
