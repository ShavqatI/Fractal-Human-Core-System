package com.fractal.controller.employment;

import com.fractal.domain.employment.salary_classification.SalaryClassificationService;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationRequest;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employment/salary-classification/{salaryClassificationId}/child")
@RequiredArgsConstructor
public class SalaryClassificationChildController {

    private final SalaryClassificationService salaryClassificationService;

    @PostMapping()
    public ResponseEntity<SalaryClassificationResponse> create(@PathVariable Long salaryClassificationId, @RequestBody @Valid SalaryClassificationRequest dto) {
        return new ResponseEntity<>(salaryClassificationService.toDTO(salaryClassificationService.addChild(salaryClassificationId, dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryClassificationResponse> update(@PathVariable Long salaryClassificationId, @PathVariable Long id, @RequestBody @Valid SalaryClassificationRequest dto) {
        return ResponseEntity.ok(salaryClassificationService.toDTO(salaryClassificationService.updateChild(salaryClassificationId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long salaryClassificationId, @PathVariable Long id) {
        salaryClassificationService.deleteChild(salaryClassificationId, id);
        return ResponseEntity.noContent().build();
    }
}
