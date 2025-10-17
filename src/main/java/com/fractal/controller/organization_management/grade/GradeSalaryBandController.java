package com.fractal.controller.organization_management.grade;

import com.fractal.domain.organization_management.grade.band.GradeSalaryBandService;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandRequest;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade/{gradeId}/salary-band")
@RequiredArgsConstructor
public class GradeSalaryBandController {

    private final GradeSalaryBandService salaryBandService;

    @PostMapping()
    public ResponseEntity<GradeSalaryBandResponse> create(@PathVariable Long gradeId, @RequestBody @Valid GradeSalaryBandRequest dto) {
        return new ResponseEntity<>(salaryBandService.toDTO(salaryBandService.create(gradeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GradeSalaryBandResponse>> getAll(@PathVariable Long gradeId) {
        return ResponseEntity.ok(salaryBandService.getAllByGradeId(gradeId).stream().map(salaryBandService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GradeSalaryBandResponse> getById(@PathVariable Long gradeId, @PathVariable Long id) {
        return ResponseEntity.ok(salaryBandService.toDTO(salaryBandService.getById(gradeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GradeSalaryBandResponse> update(@PathVariable Long gradeId, @PathVariable Long id, @RequestBody @Valid GradeSalaryBandRequest dto) {
        return ResponseEntity.ok(salaryBandService.toDTO(salaryBandService.update(gradeId,id, dto)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long gradeId, @PathVariable Long id) {
        salaryBandService.delete(gradeId,id);
        return ResponseEntity.noContent().build();
    }

}
