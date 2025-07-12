package com.fractal.controller.employee_management.subordinate;


import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateRequest;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/subordinate")
@RequiredArgsConstructor
public class SubordinateController {

    private final SubordinateService subordinateService;
    @PostMapping
    public ResponseEntity<SubordinateResponse> create(@RequestBody @Valid SubordinateRequest dto) {
        return new ResponseEntity<>(subordinateService.toDTO(subordinateService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<SubordinateResponse>> getAll() {
        return ResponseEntity.ok(subordinateService.getAll().stream().map(subordinateService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubordinateResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(subordinateService.toDTO(subordinateService.getById(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SubordinateResponse> update(@PathVariable Long id, @RequestBody @Valid SubordinateRequest dto) {
      return  ResponseEntity.ok(subordinateService.toDTO(subordinateService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subordinateService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
