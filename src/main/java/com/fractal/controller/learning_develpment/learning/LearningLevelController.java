package com.fractal.controller.learning_develpment.learning;


import com.fractal.domain.learning_develpment.learning.level.LearningLevelService;
import com.fractal.domain.learning_develpment.learning.level.dto.LearningLevelRequest;
import com.fractal.domain.learning_develpment.learning.level.dto.LearningLevelResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/level")
@RequiredArgsConstructor
public class LearningLevelController {

    private final LearningLevelService levelService;
    @PostMapping
    public ResponseEntity<LearningLevelResponse> create(@RequestBody @Valid LearningLevelRequest dto) {
        return new ResponseEntity<>(levelService.toDTO(levelService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<LearningLevelResponse>> getAll() {
        return ResponseEntity.ok(levelService.getAll().stream().map(levelService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LearningLevelResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(levelService.toDTO(levelService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<LearningLevelResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(levelService.toDTO(levelService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LearningLevelResponse> update(@PathVariable Long id, @RequestBody @Valid LearningLevelRequest dto) {
      return  ResponseEntity.ok(levelService.toDTO(levelService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        levelService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
