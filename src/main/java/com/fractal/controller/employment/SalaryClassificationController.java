package com.fractal.controller.employment;

import com.fractal.domain.employment.salary_classification.SalaryClassificationService;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationCompactResponse;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationRequest;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employment/salary-classification")
@RequiredArgsConstructor
public class SalaryClassificationController {

    private final SalaryClassificationService salaryClassificationService;


    @PostMapping
    public ResponseEntity<SalaryClassificationResponse> create(@RequestBody @Valid SalaryClassificationRequest dto) {
        return new ResponseEntity<>(salaryClassificationService.toDTO(salaryClassificationService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SalaryClassificationResponse>> getAll() {
        return ResponseEntity.ok(salaryClassificationService.getAll().stream().map(salaryClassificationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryClassificationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(salaryClassificationService.toDTO(salaryClassificationService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<SalaryClassificationResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(salaryClassificationService.toDTO(salaryClassificationService.getByCode(code)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<SalaryClassificationCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(salaryClassificationService.getAll().stream().map(salaryClassificationService::toCompactDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryClassificationResponse> update(@PathVariable Long id, @RequestBody @Valid SalaryClassificationRequest dto) {
        return ResponseEntity.ok(salaryClassificationService.toDTO(salaryClassificationService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        salaryClassificationService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
