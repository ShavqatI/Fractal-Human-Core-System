package com.fractal.controller.learning_develpment.learning.category;

import com.fractal.domain.learning_develpment.learning.category.LearningCategoryService;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryRequest;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/learning-development/learning/category/{categoryId}/child")
@RequiredArgsConstructor
public class LearningCategoryChildController {

    private final LearningCategoryService categoryService;

    @PostMapping
    public ResponseEntity<LearningCategoryResponse> create(@PathVariable Long categoryId, @RequestBody @Valid LearningCategoryRequest dto) {
        return new ResponseEntity<>(categoryService.toDTO(categoryService.addChild(categoryId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LearningCategoryResponse> update(@PathVariable Long categoryId, @PathVariable Long id, @RequestBody @Valid LearningCategoryRequest dto) {
        return ResponseEntity.ok(categoryService.toDTO(categoryService.updateChild(categoryId,id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long categoryId, @PathVariable Long id) {
        categoryService.deleteChild(categoryId,id);
        return ResponseEntity.noContent().build();
    }
}
