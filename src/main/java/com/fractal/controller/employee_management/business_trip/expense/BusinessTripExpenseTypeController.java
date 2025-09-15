package com.fractal.controller.employee_management.business_trip.expense;

import com.fractal.domain.employee_management.business_trip.expense.type.BusinessTripExpenseTypeService;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeCompactResponse;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeRequest;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip/expense/type")
@RequiredArgsConstructor
public class BusinessTripExpenseTypeController {

    private final BusinessTripExpenseTypeService businessTripExpenseTypeService;


    @PostMapping
    public ResponseEntity<BusinessTripExpenseTypeResponse> create(@RequestBody @Valid BusinessTripExpenseTypeRequest dto) {
        return new ResponseEntity<>(businessTripExpenseTypeService.toDTO(businessTripExpenseTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BusinessTripExpenseTypeResponse>> getAll() {
        return ResponseEntity.ok(businessTripExpenseTypeService.getAll().stream().map(businessTripExpenseTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripExpenseTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(businessTripExpenseTypeService.toDTO(businessTripExpenseTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<BusinessTripExpenseTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(businessTripExpenseTypeService.toDTO(businessTripExpenseTypeService.getByCode(code)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<BusinessTripExpenseTypeCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(businessTripExpenseTypeService.getAll().stream().map(businessTripExpenseTypeService::toCompactDTO).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripExpenseTypeResponse> update(@PathVariable Long id, @RequestBody @Valid BusinessTripExpenseTypeRequest dto) {
      return  ResponseEntity.ok(businessTripExpenseTypeService.toDTO(businessTripExpenseTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        businessTripExpenseTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
