package com.fractal.controller.order;


import com.fractal.domain.order.type.OrderTypeService;
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
@RequestMapping("/api/v1/order/type")
@RequiredArgsConstructor
public class OrderTypeController {

    private final OrderTypeService orderTypeService;
    @PostMapping
    public ResponseEntity<OrderTypeResponse> create(@RequestBody @Valid OrderTypeRequest dto) {
        return new ResponseEntity<>(orderTypeService.toDTO(orderTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<OrderTypeResponse>> getAll() {
        return ResponseEntity.ok(orderTypeService.getAll().stream().map(orderTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderTypeService.toDTO(orderTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<OrderTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(orderTypeService.toDTO(orderTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderTypeResponse> update(@PathVariable Long id, @RequestBody @Valid OrderTypeRequest dto) {
      return  ResponseEntity.ok(orderTypeService.toDTO(orderTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
