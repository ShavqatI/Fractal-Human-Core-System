package com.fractal.controller.employee_management.vacation;


import com.fractal.domain.employee_management.vacation.category.VacationCategoryService;
import com.fractal.domain.employee_management.vacation.category.dto.VacationCategoryRequest;
import com.fractal.domain.employee_management.vacation.category.dto.VacationCategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/v1/employee-management/vacation/category")
@RequiredArgsConstructor
public class VacationCategoryController {

    private final VacationCategoryService vacationCategoryService;
    @PostMapping
    public ResponseEntity<VacationCategoryResponse> create(@RequestBody @Valid VacationCategoryRequest dto) {
        return new ResponseEntity<>(vacationCategoryService.toDTO(vacationCategoryService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<VacationCategoryResponse>> getAll() {
        return ResponseEntity.ok(vacationCategoryService.getAll().stream().map(vacationCategoryService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VacationCategoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vacationCategoryService.toDTO(vacationCategoryService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<VacationCategoryResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(vacationCategoryService.toDTO(vacationCategoryService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<VacationCategoryResponse> update(@PathVariable Long id, @RequestBody @Valid VacationCategoryRequest dto) {
      return  ResponseEntity.ok(vacationCategoryService.toDTO(vacationCategoryService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
