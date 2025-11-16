package com.fractal.controller.learning_develpment.learning.platform;

import com.fractal.domain.learning_develpment.learning.platform.OnlinePlatformService;
import com.fractal.domain.learning_develpment.learning.platform.dto.OnlinePlatformRequest;
import com.fractal.domain.learning_develpment.learning.platform.dto.OnlinePlatformResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/online-platform")
@RequiredArgsConstructor
public class OnlinePlatformController {

    private final OnlinePlatformService onlinePlatformService;

    @PostMapping
    public ResponseEntity<OnlinePlatformResponse> create(@RequestBody @Valid OnlinePlatformRequest dto) {
        return new ResponseEntity<>(onlinePlatformService.toDTO(onlinePlatformService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OnlinePlatformResponse>> getAll() {
        return ResponseEntity.ok(onlinePlatformService.getAll().stream().map(onlinePlatformService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnlinePlatformResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(onlinePlatformService.toDTO(onlinePlatformService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<OnlinePlatformResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(onlinePlatformService.toDTO(onlinePlatformService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnlinePlatformResponse> update(@PathVariable Long id, @RequestBody @Valid OnlinePlatformRequest dto) {
        return ResponseEntity.ok(onlinePlatformService.toDTO(onlinePlatformService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        onlinePlatformService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
