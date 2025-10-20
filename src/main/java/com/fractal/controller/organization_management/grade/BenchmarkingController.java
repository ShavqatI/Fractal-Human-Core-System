package com.fractal.controller.organization_management.grade;

import com.fractal.domain.organization_management.grade.benchmarking.BenchmarkingService;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingRequest;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade-management/grade/{gradeId}/benchmarking")
@RequiredArgsConstructor
public class BenchmarkingController {

    private final BenchmarkingService benchmarkingService;

    @PostMapping()
    public ResponseEntity<BenchmarkingResponse> create(@PathVariable Long gradeId, @RequestBody @Valid BenchmarkingRequest dto) {
        return new ResponseEntity<>(benchmarkingService.toDTO(benchmarkingService.create(gradeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BenchmarkingResponse>> getAll(@PathVariable Long gradeId) {
        return ResponseEntity.ok(benchmarkingService.getAllByGradeId(gradeId).stream().map(benchmarkingService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BenchmarkingResponse> getById(@PathVariable Long gradeId, @PathVariable Long id) {
        return ResponseEntity.ok(benchmarkingService.toDTO(benchmarkingService.getById(gradeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BenchmarkingResponse> update(@PathVariable Long gradeId, @PathVariable Long id, @RequestBody @Valid BenchmarkingRequest dto) {
        return ResponseEntity.ok(benchmarkingService.toDTO(benchmarkingService.update(gradeId,id, dto)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long gradeId, @PathVariable Long id) {
        benchmarkingService.delete(gradeId,id);
        return ResponseEntity.noContent().build();
    }

}
