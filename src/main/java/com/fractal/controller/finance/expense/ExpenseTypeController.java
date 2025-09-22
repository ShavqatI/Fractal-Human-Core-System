package com.fractal.controller.finance.expense;

import com.fractal.domain.finance.expense.type.ExpenseTypeService;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeCompactResponse;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeRequest;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/finance/expense-type")
@RequiredArgsConstructor
public class ExpenseTypeController {

    private final ExpenseTypeService expenseTypeService;


    @PostMapping
    public ResponseEntity<ExpenseTypeResponse> create(@RequestBody @Valid ExpenseTypeRequest dto) {
        return new ResponseEntity<>(expenseTypeService.toDTO(expenseTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ExpenseTypeResponse>> getAll() {
        return ResponseEntity.ok(expenseTypeService.getAll().stream().map(expenseTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseTypeService.toDTO(expenseTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<ExpenseTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(expenseTypeService.toDTO(expenseTypeService.getByCode(code)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<ExpenseTypeCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(expenseTypeService.getAll().stream().map(expenseTypeService::toCompactDTO).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseTypeResponse> update(@PathVariable Long id, @RequestBody @Valid ExpenseTypeRequest dto) {
      return  ResponseEntity.ok(expenseTypeService.toDTO(expenseTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        expenseTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
