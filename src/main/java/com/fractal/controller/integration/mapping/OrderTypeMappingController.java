package com.fractal.controller.integration.mapping;

import com.fractal.domain.finance.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.finance.currency.dto.CurrencyRequest;
import com.fractal.domain.finance.currency.dto.CurrencyResponse;
import com.fractal.domain.integration.mapping.order_type.OrderTypeMappingService;
import com.fractal.domain.integration.mapping.order_type.dto.OrderTypeMappingRequest;
import com.fractal.domain.integration.mapping.order_type.dto.OrderTypeMappingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/integration/mapping/order-type")
@RequiredArgsConstructor
public class OrderTypeMappingController {

    private final OrderTypeMappingService orderTypeMappingService;


    @PostMapping
    public ResponseEntity<OrderTypeMappingResponse> create(@RequestBody @Valid OrderTypeMappingRequest dto) {
        return new ResponseEntity<>(orderTypeMappingService.toDTO(orderTypeMappingService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<OrderTypeMappingResponse>> getAll() {
        return ResponseEntity.ok(orderTypeMappingService.getAll().stream().map(orderTypeMappingService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderTypeMappingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderTypeMappingService.toDTO(orderTypeMappingService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderTypeMappingResponse> update(@PathVariable Long id, @RequestBody @Valid OrderTypeMappingRequest dto) {
      return  ResponseEntity.ok(orderTypeMappingService.toDTO(orderTypeMappingService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderTypeMappingService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
