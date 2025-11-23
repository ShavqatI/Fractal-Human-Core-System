package com.fractal.controller.order;


import com.fractal.domain.order.employment.record.InternalEmploymentOrderRecordService;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-management/internal-employment/{orderId}/record")
@RequiredArgsConstructor
public class InternalEmploymentOrderRecordController {

    private final InternalEmploymentOrderRecordService recordService;

    @PostMapping()
    public ResponseEntity<InternalEmploymentOrderRecordResponse> create(@PathVariable Long orderId, @RequestBody @Valid InternalEmploymentOrderRecordRequest dto) {
        return new ResponseEntity<>(recordService.toDTO(recordService.create(orderId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InternalEmploymentOrderRecordResponse>> getAll(@PathVariable Long orderId) {
        return ResponseEntity.ok(recordService.getAllByInternalEmploymentOrderId(orderId).stream().map(recordService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternalEmploymentOrderRecordResponse> getById(@PathVariable Long orderId, @PathVariable Long id) {
        return ResponseEntity.ok(recordService.toDTO(recordService.getById(orderId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternalEmploymentOrderRecordResponse> update(@PathVariable Long orderId, @PathVariable Long id, @RequestBody @Valid InternalEmploymentOrderRecordRequest dto) {
        return ResponseEntity.ok(recordService.toDTO(recordService.update(orderId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long orderId, @PathVariable Long id) {
        recordService.delete(orderId, id);
        return ResponseEntity.noContent().build();
    }


}
