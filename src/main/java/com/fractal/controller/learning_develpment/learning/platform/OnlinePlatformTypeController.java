package com.fractal.controller.learning_develpment.learning.platform;


import com.fractal.domain.learning_develpment.learning.platform.type.OnlinePlatformTypeService;
import com.fractal.domain.learning_develpment.learning.platform.type.dto.OnlinePlatformTypeRequest;
import com.fractal.domain.learning_develpment.learning.platform.type.dto.OnlinePlatformTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/online-platform/type")
@RequiredArgsConstructor
public class OnlinePlatformTypeController {

    private final OnlinePlatformTypeService typeService;

    @PostMapping
    public ResponseEntity<OnlinePlatformTypeResponse> create(@RequestBody @Valid OnlinePlatformTypeRequest dto) {
        return new ResponseEntity<>(typeService.toDTO(typeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OnlinePlatformTypeResponse>> getAll() {
        return ResponseEntity.ok(typeService.getAll().stream().map(typeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnlinePlatformTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.toDTO(typeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<OnlinePlatformTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(typeService.toDTO(typeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnlinePlatformTypeResponse> update(@PathVariable Long id, @RequestBody @Valid OnlinePlatformTypeRequest dto) {
        return ResponseEntity.ok(typeService.toDTO(typeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
