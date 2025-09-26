package com.fractal.controller.learning_develpment.learning;

import com.fractal.domain.learning_develpment.learning.LearningService;
import com.fractal.domain.learning_develpment.learning.dto.LearningCompactResponse;
import com.fractal.domain.learning_develpment.learning.dto.LearningRequest;
import com.fractal.domain.learning_develpment.learning.dto.LearningResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning")
@RequiredArgsConstructor
public class LearningController {

    private final LearningService learningService;

    @PostMapping
    public ResponseEntity<LearningResponse> create(@RequestBody @Valid LearningRequest dto) {
        return new ResponseEntity<>(learningService.toDTO(learningService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningResponse>> getAll() {
        return ResponseEntity.ok(learningService.getAll().stream().map(learningService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(learningService.toDTO(learningService.getById(id)));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<LearningCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(learningService.getAll().stream().map(learningService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<LearningCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(learningService.toCompactDTO(learningService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningResponse> update(@PathVariable Long id, @RequestBody @Valid LearningRequest dto) {
        return ResponseEntity.ok(learningService.toDTO(learningService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        learningService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
