package com.fractal.controller.employee_management.business_trip;


import com.fractal.domain.employee_management.business_trip.order.BusinessTripOrderService;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderRequest;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip/{businessTripId}/order")
@RequiredArgsConstructor
public class BusinessTripOrderController {

    private final BusinessTripOrderService orderService;

    @PostMapping()
    public ResponseEntity<BusinessTripOrderResponse> create(@PathVariable Long businessTripId, @RequestBody @Valid BusinessTripOrderRequest dto) {
        return new ResponseEntity<>(orderService.toDTO(orderService.create(businessTripId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessTripOrderResponse>> getAll(@PathVariable Long businessTripId) {
        return ResponseEntity.ok(orderService.getAllByBusinessTripId(businessTripId).stream().map(orderService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripOrderResponse> getById(@PathVariable Long businessTripId, @PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.getById(businessTripId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripOrderResponse> update(@PathVariable Long businessTripId, @PathVariable Long id, @RequestBody @Valid BusinessTripOrderRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.update(businessTripId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long businessTripId, @PathVariable Long id) {
        orderService.delete(businessTripId, id);
        return ResponseEntity.noContent().build();
    }


}
