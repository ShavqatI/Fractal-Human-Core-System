package com.fractal.controller.organization_management.grade;

import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.grade.dto.GradeRequest;
import com.fractal.domain.organization_management.grade.dto.GradeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organization-management/grade/{gradeId}/child")
@RequiredArgsConstructor
public class GradeChildController {

    private final GradeService gradeService;

    @PostMapping()
    public ResponseEntity<GradeResponse> create(@PathVariable Long gradeId, @RequestBody @Valid GradeRequest dto) {
        return new ResponseEntity<>(gradeService.toDTO(gradeService.addChild(gradeId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GradeResponse> update(@PathVariable Long gradeId, @PathVariable Long id, @RequestBody @Valid GradeRequest dto) {
        return ResponseEntity.ok(gradeService.toDTO(gradeService.updateChild(gradeId,id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long gradeId, @PathVariable Long id) {
        gradeService.deleteChild(gradeId,id);
        return ResponseEntity.noContent().build();
    }
}
