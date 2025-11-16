package com.fractal.controller.navigation.action;


import com.fractal.domain.navigation.action.category.ActionCategoryService;
import com.fractal.domain.navigation.action.category.dto.ActionCategoryRequest;
import com.fractal.domain.navigation.action.category.dto.ActionCategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/navigation/action/category")
@RequiredArgsConstructor
public class ActionCategoryController {

    private final ActionCategoryService actionCategoryService;

    @PostMapping
    public ResponseEntity<ActionCategoryResponse> create(@RequestBody @Valid ActionCategoryRequest dto) {
        return new ResponseEntity<>(actionCategoryService.toDTO(actionCategoryService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActionCategoryResponse>> getAll() {
        return ResponseEntity.ok(actionCategoryService.getAll().stream().map(actionCategoryService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActionCategoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(actionCategoryService.toDTO(actionCategoryService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ActionCategoryResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(actionCategoryService.toDTO(actionCategoryService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActionCategoryResponse> update(@PathVariable Long id, @RequestBody @Valid ActionCategoryRequest dto) {
        return ResponseEntity.ok(actionCategoryService.toDTO(actionCategoryService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        actionCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
