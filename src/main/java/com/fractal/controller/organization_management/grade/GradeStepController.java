package com.fractal.controller.organization_management.grade;

import com.fractal.domain.organization_management.grade.step.GradeStepService;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepRequest;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade-management/grade/{gradeId}/step")
@RequiredArgsConstructor
public class GradeStepController {

    private final GradeStepService gradeStepService;

    @PostMapping()
    public ResponseEntity<GradeStepResponse> create(@PathVariable Long gradeId, @RequestBody @Valid GradeStepRequest dto) {
        return new ResponseEntity<>(gradeStepService.toDTO(gradeStepService.create(gradeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GradeStepResponse>> getAll(@PathVariable Long gradeId) {
        return ResponseEntity.ok(gradeStepService.getAllByGradeId(gradeId).stream().map(gradeStepService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GradeStepResponse> getById(@PathVariable Long gradeId, @PathVariable Long id) {
        return ResponseEntity.ok(gradeStepService.toDTO(gradeStepService.getById(gradeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GradeStepResponse> update(@PathVariable Long gradeId, @PathVariable Long id, @RequestBody @Valid GradeStepRequest dto) {
        return ResponseEntity.ok(gradeStepService.toDTO(gradeStepService.update(gradeId,id, dto)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long gradeId, @PathVariable Long id) {
        gradeStepService.delete(gradeId,id);
        return ResponseEntity.noContent().build();
    }

}
