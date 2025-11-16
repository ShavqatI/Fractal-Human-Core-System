package com.fractal.controller.finance.expense;

import com.fractal.domain.finance.expense.type.category.ExpenseTypeCategoryService;
import com.fractal.domain.finance.expense.type.category.dto.ExpenseTypeCategoryRequest;
import com.fractal.domain.finance.expense.type.category.dto.ExpenseTypeCategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/finance/expense-type/category")
@RequiredArgsConstructor
public class ExpenseTypeCategoryController {

    private final ExpenseTypeCategoryService categoryService;


    @PostMapping
    public ResponseEntity<ExpenseTypeCategoryResponse> create(@RequestBody @Valid ExpenseTypeCategoryRequest dto) {
        return new ResponseEntity<>(categoryService.toDTO(categoryService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseTypeCategoryResponse>> getAll() {
        return ResponseEntity.ok(categoryService.getAll().stream().map(categoryService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseTypeCategoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.toDTO(categoryService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ExpenseTypeCategoryResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(categoryService.toDTO(categoryService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseTypeCategoryResponse> update(@PathVariable Long id, @RequestBody @Valid ExpenseTypeCategoryRequest dto) {
        return ResponseEntity.ok(categoryService.toDTO(categoryService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
