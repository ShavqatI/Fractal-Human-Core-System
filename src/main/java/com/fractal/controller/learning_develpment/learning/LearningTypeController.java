package com.fractal.controller.learning_develpment.learning;


import com.fractal.domain.learning_develpment.learning.type.LearningTypeService;
import com.fractal.domain.learning_develpment.learning.type.dto.LearningTypeRequest;
import com.fractal.domain.learning_develpment.learning.type.dto.LearningTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/type")
@RequiredArgsConstructor
public class LearningTypeController {

    private final LearningTypeService typeService;

    @PostMapping
    public ResponseEntity<LearningTypeResponse> create(@RequestBody @Valid LearningTypeRequest dto) {
        return new ResponseEntity<>(typeService.toDTO(typeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningTypeResponse>> getAll() {
        return ResponseEntity.ok(typeService.getAll().stream().map(typeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.toDTO(typeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<LearningTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(typeService.toDTO(typeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningTypeResponse> update(@PathVariable Long id, @RequestBody @Valid LearningTypeRequest dto) {
        return ResponseEntity.ok(typeService.toDTO(typeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
