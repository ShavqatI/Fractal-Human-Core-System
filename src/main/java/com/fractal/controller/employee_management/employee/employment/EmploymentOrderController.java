package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employment.internal.order.InternalEmploymentOrderService;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/employment/{employmentId}/order")
@RequiredArgsConstructor
public class EmploymentOrderController {

    private final InternalEmploymentOrderService orderService;

    @PostMapping()
    public ResponseEntity<InternalEmploymentOrderResponse> create(@PathVariable Long employmentId, @RequestBody @Valid InternalEmploymentOrderRequest dto) {
        return new ResponseEntity<>(orderService.toDTO(orderService.create(employmentId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InternalEmploymentOrderResponse>> getAll(@PathVariable Long employmentId) {
        return ResponseEntity.ok(orderService.getAllByInternalEmploymentId(employmentId).stream().map(orderService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternalEmploymentOrderResponse> getById(@PathVariable Long employmentId, @PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.getById(employmentId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternalEmploymentOrderResponse> update(@PathVariable Long employmentId, @PathVariable Long id, @RequestBody @Valid InternalEmploymentOrderRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.update(employmentId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employmentId, @PathVariable Long id) {
        orderService.delete(employmentId, id);
        return ResponseEntity.noContent().build();
    }


}
