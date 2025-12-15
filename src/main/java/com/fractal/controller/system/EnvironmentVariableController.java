package com.fractal.controller.system;


import com.fractal.domain.system.environment_variable.EnvironmentVariableService;
import com.fractal.domain.system.environment_variable.dto.EnvironmentVariableRequest;
import com.fractal.domain.system.environment_variable.dto.EnvironmentVariableResponse;
import com.fractal.domain.system.message.dto.MessageRequest;
import com.fractal.domain.system.message.dto.MessageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/system/environment-variable")
@RequiredArgsConstructor
public class EnvironmentVariableController {

    private final EnvironmentVariableService environmentVariableService;

    @PostMapping
    public ResponseEntity<EnvironmentVariableResponse> create(@RequestBody @Valid EnvironmentVariableRequest dto) {
        return new ResponseEntity<>(environmentVariableService.toDTO(environmentVariableService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnvironmentVariableResponse>> getAll() {
        return ResponseEntity.ok(environmentVariableService.getAll().stream().map(environmentVariableService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironmentVariableResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(environmentVariableService.toDTO(environmentVariableService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<EnvironmentVariableResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(environmentVariableService.toDTO(environmentVariableService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentVariableResponse> update(@PathVariable Long id, @RequestBody @Valid EnvironmentVariableRequest dto) {
        return ResponseEntity.ok(environmentVariableService.toDTO(environmentVariableService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        environmentVariableService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
