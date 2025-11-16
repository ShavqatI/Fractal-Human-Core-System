package com.fractal.controller.testing.test;


import com.fractal.domain.testing.test.TestService;
import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.dto.TestRequest;
import com.fractal.domain.testing.test.dto.TestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/testing/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping
    public ResponseEntity<TestResponse> create(@RequestBody @Valid TestRequest dto) {
        return new ResponseEntity<>(testService.toDTO(testService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestResponse>> getAll() {
        return ResponseEntity.ok(testService.getAll().stream().map(testService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(testService.toDTO(testService.getById(id)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<TestCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(testService.getAll().stream().map(testService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<TestCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(testService.toCompactDTO(testService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestResponse> update(@PathVariable Long id, @RequestBody @Valid TestRequest dto) {
        return ResponseEntity.ok(testService.toDTO(testService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        testService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
