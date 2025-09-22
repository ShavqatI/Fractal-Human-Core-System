package com.fractal.controller.finance.expense;


import com.fractal.domain.finance.expense.resource.ExpenseResourceService;
import com.fractal.domain.resource.dto.ResourceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/finance/expense/{expenseId}/resource")
@RequiredArgsConstructor
public class ExpenseResourceController {

    private final ExpenseResourceService resourceService;

    @PostMapping()
    public ResponseEntity<ResourceResponse> create(@PathVariable Long expenseId, @RequestBody @Valid MultipartFile file) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(expenseId,file)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll(@PathVariable Long expenseId) {
        return ResponseEntity.ok(resourceService.getAllByExpenseId(expenseId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable Long expenseId, @PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(expenseId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResourceResponse> update(@PathVariable Long expenseId, @PathVariable Long id, @RequestBody @Valid MultipartFile file) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(expenseId,id, file)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long expenseId, @PathVariable Long id) {
        resourceService.delete(expenseId,id);
        return ResponseEntity.noContent().build();
    }



}
