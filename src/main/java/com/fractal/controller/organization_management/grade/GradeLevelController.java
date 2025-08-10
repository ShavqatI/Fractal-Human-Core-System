package com.fractal.controller.organization_management.grade;


import com.fractal.domain.organization_management.grade.level.GradeLevelService;
import com.fractal.domain.organization_management.grade.level.dto.GradeLevelRequest;
import com.fractal.domain.organization_management.grade.level.dto.GradeLevelResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade/level")
@RequiredArgsConstructor
public class GradeLevelController {

    private final GradeLevelService gradeLevelService;
    @PostMapping
    public ResponseEntity<GradeLevelResponse> create(@RequestBody @Valid GradeLevelRequest dto) {
        return new ResponseEntity<>(gradeLevelService.toDTO(gradeLevelService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GradeLevelResponse>> getAll() {
        return ResponseEntity.ok(gradeLevelService.getAll().stream().map(gradeLevelService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GradeLevelResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(gradeLevelService.toDTO(gradeLevelService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<GradeLevelResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(gradeLevelService.toDTO(gradeLevelService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GradeLevelResponse> update(@PathVariable Long id, @RequestBody @Valid GradeLevelRequest dto) {
      return  ResponseEntity.ok(gradeLevelService.toDTO(gradeLevelService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gradeLevelService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
