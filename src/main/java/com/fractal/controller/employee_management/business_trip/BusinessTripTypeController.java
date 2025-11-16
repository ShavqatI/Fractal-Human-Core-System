package com.fractal.controller.employee_management.business_trip;


import com.fractal.domain.employee_management.business_trip.type.BusinessTripTypeService;
import com.fractal.domain.employee_management.business_trip.type.dto.BusinessTripTypeRequest;
import com.fractal.domain.employee_management.business_trip.type.dto.BusinessTripTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip/type")
@RequiredArgsConstructor
public class BusinessTripTypeController {

    private final BusinessTripTypeService businessTripTypeService;

    @PostMapping
    public ResponseEntity<BusinessTripTypeResponse> create(@RequestBody @Valid BusinessTripTypeRequest dto) {
        return new ResponseEntity<>(businessTripTypeService.toDTO(businessTripTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessTripTypeResponse>> getAll() {
        return ResponseEntity.ok(businessTripTypeService.getAll().stream().map(businessTripTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(businessTripTypeService.toDTO(businessTripTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<BusinessTripTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(businessTripTypeService.toDTO(businessTripTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripTypeResponse> update(@PathVariable Long id, @RequestBody @Valid BusinessTripTypeRequest dto) {
        return ResponseEntity.ok(businessTripTypeService.toDTO(businessTripTypeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        businessTripTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
