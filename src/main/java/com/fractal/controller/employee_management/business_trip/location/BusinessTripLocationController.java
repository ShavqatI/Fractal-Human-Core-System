package com.fractal.controller.employee_management.business_trip.location;


import com.fractal.domain.employee_management.business_trip.location.BusinessTripLocationService;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationRequest;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip/{businessTripId}/location")
@RequiredArgsConstructor
public class BusinessTripLocationController {

    private final BusinessTripLocationService locationService;

    @PostMapping()
    public ResponseEntity<BusinessTripLocationResponse> create(@PathVariable Long businessTripId, @RequestBody @Valid BusinessTripLocationRequest dto) {
        return new ResponseEntity<>(locationService.toDTO(locationService.create(businessTripId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BusinessTripLocationResponse>> getAll(@PathVariable Long businessTripId) {
        return ResponseEntity.ok(locationService.getAllByBusinessTripId(businessTripId).stream().map(locationService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripLocationResponse> getById(@PathVariable Long businessTripId,@PathVariable Long id) {
        return ResponseEntity.ok(locationService.toDTO(locationService.getById(businessTripId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripLocationResponse> update(@PathVariable Long businessTripId, @PathVariable Long id, @RequestBody @Valid BusinessTripLocationRequest dto) {
        return ResponseEntity.ok(locationService.toDTO(locationService.update(businessTripId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long businessTripId, @PathVariable Long id) {
        locationService.delete(businessTripId,id);
        return ResponseEntity.noContent().build();
    }



}
