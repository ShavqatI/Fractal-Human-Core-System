package com.fractal.controller.order;


import com.fractal.domain.order.business_trip.record.BusinessTripOrderRecordService;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordRequest;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-management/business-trip/{orderId}/record")
@RequiredArgsConstructor
public class BusinessTripOrderRecordController {

    private final BusinessTripOrderRecordService recordService;

    @PostMapping()
    public ResponseEntity<BusinessTripOrderRecordResponse> create(@PathVariable Long orderId, @RequestBody @Valid BusinessTripOrderRecordRequest dto) {
        return new ResponseEntity<>(recordService.toDTO(recordService.create(orderId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessTripOrderRecordResponse>> getAll(@PathVariable Long orderId) {
        return ResponseEntity.ok(recordService.getAllByBusinessTripOrderId(orderId).stream().map(recordService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripOrderRecordResponse> getById(@PathVariable Long orderId, @PathVariable Long id) {
        return ResponseEntity.ok(recordService.toDTO(recordService.getById(orderId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripOrderRecordResponse> update(@PathVariable Long orderId, @PathVariable Long id, @RequestBody @Valid BusinessTripOrderRecordRequest dto) {
        return ResponseEntity.ok(recordService.toDTO(recordService.update(orderId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long orderId, @PathVariable Long id) {
        recordService.delete(orderId, id);
        return ResponseEntity.noContent().build();
    }


}
