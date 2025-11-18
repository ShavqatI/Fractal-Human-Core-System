package com.fractal.controller.order;


import com.fractal.domain.order.business_trip.BusinessTripOrderService;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;
import com.fractal.domain.order.vacation.VacationOrderService;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
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

    @GetMapping("print/{id}")
    public ResponseEntity<BusinessTripOrderResponse> print( @PathVariable Long id) {
       return null;
    }




}
