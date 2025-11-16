package com.fractal.controller.employee_management.business_trip;


import com.fractal.domain.employee_management.business_trip.expense.BusinessTripExpenseService;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseRequest;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip/{businessTripId}/expense")
@RequiredArgsConstructor
public class BusinessTripExpenseController {

    private final BusinessTripExpenseService expenseService;

    @PostMapping()
    public ResponseEntity<BusinessTripExpenseResponse> create(@PathVariable Long businessTripId, @RequestBody @Valid BusinessTripExpenseRequest dto) {
        return new ResponseEntity<>(expenseService.toDTO(expenseService.create(businessTripId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessTripExpenseResponse>> getAll(@PathVariable Long businessTripId) {
        return ResponseEntity.ok(expenseService.getAllByBusinessTripId(businessTripId).stream().map(expenseService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripExpenseResponse> getById(@PathVariable Long businessTripId, @PathVariable Long id) {
        return ResponseEntity.ok(expenseService.toDTO(expenseService.getById(businessTripId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripExpenseResponse> update(@PathVariable Long businessTripId, @PathVariable Long id, @RequestBody @Valid BusinessTripExpenseRequest dto) {
        return ResponseEntity.ok(expenseService.toDTO(expenseService.update(businessTripId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long businessTripId, @PathVariable Long id) {
        expenseService.delete(businessTripId, id);
        return ResponseEntity.noContent().build();
    }


}
