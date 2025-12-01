package com.fractal.controller.order;


import com.fractal.domain.order.business_trip.BusinessTripOrderService;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;
import com.fractal.domain.resource.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-management/business-trip")
@RequiredArgsConstructor
public class BusinessTripOrderController {

    private final BusinessTripOrderService orderService;
    private final FileService fileService;

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
    @CrossOrigin(value = "*")
    public ResponseEntity<StreamingResponseBody> print(@PathVariable Long id) {
        Path path = orderService.print(id);
        return fileService.view(path);
    }
}
