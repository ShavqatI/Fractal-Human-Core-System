package com.fractal.controller.testing.test.session;


import com.fractal.domain.testing.test.session.TestSessionService;
import com.fractal.domain.testing.test.session.dto.TestSessionRequest;
import com.fractal.domain.testing.test.session.dto.TestSessionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/testing/test-session")
@RequiredArgsConstructor
public class TestSessionController {

    private final TestSessionService testSessionService;

    @PostMapping
    public ResponseEntity<TestSessionResponse> create(@RequestBody @Valid TestSessionRequest dto) {
        return new ResponseEntity<>(testSessionService.toDTO(testSessionService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TestSessionResponse>> getAll() {
        return ResponseEntity.ok(testSessionService.getAll().stream().map(testSessionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestSessionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(testSessionService.toDTO(testSessionService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestSessionResponse> update(@PathVariable Long id, @RequestBody @Valid TestSessionRequest dto) {
      return  ResponseEntity.ok(testSessionService.toDTO(testSessionService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        testSessionService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
