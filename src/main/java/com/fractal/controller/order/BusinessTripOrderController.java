package com.fractal.controller.order;


import com.fractal.domain.order.business_trip.BusinessTripOrderService;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-management/business-trip")
@RequiredArgsConstructor
public class BusinessTripOrderController {

    private final BusinessTripOrderService orderService;

    @PostMapping()
    public ResponseEntity<BusinessTripOrderResponse> create(@RequestBody @Valid BusinessTripOrderRequest dto) {
        return new ResponseEntity<>(orderService.toDTO(orderService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessTripOrderResponse>> getAll() {
        return ResponseEntity.ok(orderService.getAll().stream().map(orderService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripOrderResponse> getById( @PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripOrderResponse> update(@PathVariable Long id, @RequestBody @Valid BusinessTripOrderRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("review/{id}")
    public ResponseEntity<BusinessTripOrderResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.review(id)));
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<BusinessTripOrderResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.approve(id)));
    }

    @GetMapping("print/{id}")
    public ResponseEntity<BusinessTripOrderResponse> print( @PathVariable Long id) {
       return null;
    }




}
