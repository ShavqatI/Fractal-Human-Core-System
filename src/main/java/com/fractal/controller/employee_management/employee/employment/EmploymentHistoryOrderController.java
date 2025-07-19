package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employee_management.employment.order.EmploymentHistoryOrderService;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderRequest;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/employment-history/{employmentHistoryId}/order")
@RequiredArgsConstructor
public class EmploymentHistoryOrderController {

    private final EmploymentHistoryOrderService orderService;

    @PostMapping()
    public ResponseEntity<EmploymentHistoryOrderResponse> create(@PathVariable Long employmentHistoryId, @RequestBody @Valid EmploymentHistoryOrderRequest dto) {
        return new ResponseEntity<>(orderService.toDTO(orderService.create(employmentHistoryId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmploymentHistoryOrderResponse>> getAll(@PathVariable Long employmentHistoryId) {
        return ResponseEntity.ok(orderService.getAllByEmploymentHistoryId(employmentHistoryId).stream().map(orderService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentHistoryOrderResponse> getById(@PathVariable Long employmentHistoryId,@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.getById(employmentHistoryId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentHistoryOrderResponse> update(@PathVariable Long employmentHistoryId, @PathVariable Long id, @RequestBody @Valid EmploymentHistoryOrderRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.update(employmentHistoryId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employmentHistoryId, @PathVariable Long id) {
        orderService.delete(employmentHistoryId,id);
        return ResponseEntity.noContent().build();
    }



}
