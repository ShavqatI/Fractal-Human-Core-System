package com.fractal.controller.dictionary.status;


import com.fractal.domain.dictionary.status.category.StatusCategoryService;
import com.fractal.domain.dictionary.status.category.dto.StatusCategoryRequest;
import com.fractal.domain.dictionary.status.category.dto.StatusCategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/status/category")
@RequiredArgsConstructor
public class StatusCategoryController {

    private final StatusCategoryService statusCategoryService;

    @PostMapping
    public ResponseEntity<StatusCategoryResponse> create(@RequestBody @Valid StatusCategoryRequest dto) {
        return new ResponseEntity<>(statusCategoryService.toDTO(statusCategoryService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StatusCategoryResponse>> getAll() {
        return ResponseEntity.ok(statusCategoryService.getAll().stream().map(statusCategoryService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusCategoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(statusCategoryService.toDTO(statusCategoryService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<StatusCategoryResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(statusCategoryService.toDTO(statusCategoryService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusCategoryResponse> update(@PathVariable Long id, @RequestBody @Valid StatusCategoryRequest dto) {
        return ResponseEntity.ok(statusCategoryService.toDTO(statusCategoryService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        statusCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
