package com.fractal.controller.learning_develpment.learning.category;

import com.fractal.domain.learning_develpment.learning.category.LearningCategoryService;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryCompactResponse;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryRequest;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/category")
@RequiredArgsConstructor
public class LearningCategoryController {

    private final LearningCategoryService categoryService;

    @PostMapping
    public ResponseEntity<LearningCategoryResponse> create(@RequestBody @Valid LearningCategoryRequest dto) {
        return new ResponseEntity<>(categoryService.toDTO(categoryService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningCategoryResponse>> getAll() {
        return ResponseEntity.ok(categoryService.getAll().stream().map(categoryService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningCategoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.toDTO(categoryService.getById(id)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<LearningCategoryCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(categoryService.getAll().stream().map(categoryService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<LearningCategoryCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.toCompactDTO(categoryService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<LearningCategoryResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(categoryService.toDTO(categoryService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningCategoryResponse> update(@PathVariable Long id, @RequestBody @Valid LearningCategoryRequest dto) {
        return ResponseEntity.ok(categoryService.toDTO(categoryService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
