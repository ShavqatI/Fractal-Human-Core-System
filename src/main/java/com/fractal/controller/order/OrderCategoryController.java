package com.fractal.controller.order;


import com.fractal.domain.order.category.OrderCategoryService;
import com.fractal.domain.order.category.dto.OrderCategoryRequest;
import com.fractal.domain.order.category.dto.OrderCategoryResponse;
import com.fractal.domain.order.type.dto.OrderTypeRequest;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-management/category")
@RequiredArgsConstructor
public class OrderCategoryController {

    private final OrderCategoryService orderCategoryService;

    @PostMapping
    public ResponseEntity<OrderCategoryResponse> create(@RequestBody @Valid OrderCategoryRequest dto) {
        return new ResponseEntity<>(orderCategoryService.toDTO(orderCategoryService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderCategoryResponse>> getAll() {
        return ResponseEntity.ok(orderCategoryService.getAll().stream().map(orderCategoryService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderCategoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderCategoryService.toDTO(orderCategoryService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<OrderCategoryResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(orderCategoryService.toDTO(orderCategoryService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderCategoryResponse> update(@PathVariable Long id, @RequestBody @Valid OrderCategoryRequest dto) {
        return ResponseEntity.ok(orderCategoryService.toDTO(orderCategoryService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
