package com.fractal.controller.order;


import com.fractal.domain.order.employment.EmploymentOrderService;
import com.fractal.domain.order.employment.dto.EmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.EmploymentOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-management/employment")
@RequiredArgsConstructor
public class EmploymentOrderController {

    private final EmploymentOrderService orderService;

    @PostMapping()
    public ResponseEntity<EmploymentOrderResponse> create(@RequestBody @Valid EmploymentOrderRequest dto) {
        return new ResponseEntity<>(orderService.toDTO(orderService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentOrderResponse>> getAll() {
        return ResponseEntity.ok(orderService.getAll().stream().map(orderService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentOrderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentOrderResponse> update(@PathVariable Long id, @RequestBody @Valid EmploymentOrderRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.update(id, dto)));
    }
    @PutMapping("review/{id}")
    public ResponseEntity<EmploymentOrderResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.review(id)));
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<EmploymentOrderResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.approve(id)));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
