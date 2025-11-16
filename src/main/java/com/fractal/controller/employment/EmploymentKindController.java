package com.fractal.controller.employment;


import com.fractal.domain.employment.kind.EmploymentKindService;
import com.fractal.domain.employment.kind.dto.EmploymentKindRequest;
import com.fractal.domain.employment.kind.dto.EmploymentKindResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employment/kind")
@RequiredArgsConstructor
public class EmploymentKindController {

    private final EmploymentKindService employmentKindService;

    @PostMapping
    public ResponseEntity<EmploymentKindResponse> create(@RequestBody @Valid EmploymentKindRequest dto) {
        return new ResponseEntity<>(employmentKindService.toDTO(employmentKindService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentKindResponse>> getAll() {
        return ResponseEntity.ok(employmentKindService.getAll().stream().map(employmentKindService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentKindResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employmentKindService.toDTO(employmentKindService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<EmploymentKindResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(employmentKindService.toDTO(employmentKindService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentKindResponse> update(@PathVariable Long id, @RequestBody @Valid EmploymentKindRequest dto) {
        return ResponseEntity.ok(employmentKindService.toDTO(employmentKindService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employmentKindService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
