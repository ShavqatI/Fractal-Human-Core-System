package com.fractal.controller.employee_management.business_trip;


import com.fractal.domain.employee_management.business_trip.purpose.BusinessTripPurposeService;
import com.fractal.domain.employee_management.business_trip.purpose.dto.BusinessTripPurposeRequest;
import com.fractal.domain.employee_management.business_trip.purpose.dto.BusinessTripPurposeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip/purpose")
@RequiredArgsConstructor
public class BusinessTripPurposeController {

    private final BusinessTripPurposeService businessTripPurposeService;

    @PostMapping
    public ResponseEntity<BusinessTripPurposeResponse> create(@RequestBody @Valid BusinessTripPurposeRequest dto) {
        return new ResponseEntity<>(businessTripPurposeService.toDTO(businessTripPurposeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessTripPurposeResponse>> getAll() {
        return ResponseEntity.ok(businessTripPurposeService.getAll().stream().map(businessTripPurposeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripPurposeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(businessTripPurposeService.toDTO(businessTripPurposeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<BusinessTripPurposeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(businessTripPurposeService.toDTO(businessTripPurposeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripPurposeResponse> update(@PathVariable Long id, @RequestBody @Valid BusinessTripPurposeRequest dto) {
        return ResponseEntity.ok(businessTripPurposeService.toDTO(businessTripPurposeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        businessTripPurposeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
