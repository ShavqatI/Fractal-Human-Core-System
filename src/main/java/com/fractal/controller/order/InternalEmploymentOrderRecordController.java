package com.fractal.controller.order;


import com.fractal.domain.order.employment.record.EmploymentOrderRecordService;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordResponse;
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

    private final EmploymentOrderRecordService recordService;

    @PostMapping()
    public ResponseEntity<EmploymentOrderRecordResponse> create(@PathVariable Long orderId, @RequestBody @Valid EmploymentOrderRecordRequest dto) {
        return new ResponseEntity<>(recordService.toDTO(recordService.create(orderId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentOrderRecordResponse>> getAll(@PathVariable Long orderId) {
        return ResponseEntity.ok(recordService.getAllByInternalEmploymentOrderId(orderId).stream().map(recordService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentOrderRecordResponse> getById(@PathVariable Long orderId, @PathVariable Long id) {
        return ResponseEntity.ok(recordService.toDTO(recordService.getById(orderId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentOrderRecordResponse> update(@PathVariable Long orderId, @PathVariable Long id, @RequestBody @Valid EmploymentOrderRecordRequest dto) {
        return ResponseEntity.ok(recordService.toDTO(recordService.update(orderId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long orderId, @PathVariable Long id) {
        recordService.delete(orderId, id);
        return ResponseEntity.noContent().build();
    }


}
