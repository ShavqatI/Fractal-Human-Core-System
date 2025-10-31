package com.fractal.controller.employee_management.business_trip.location;


import com.fractal.domain.employee_management.business_trip.location.address.BusinessTripLocationAddressService;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressRequest;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressResponse;
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
@RequestMapping("/api/v1/employee-management/business-trip/location/{locationId}/address")
@RequiredArgsConstructor
public class BusinessTripLocationAddressController {

    private final BusinessTripLocationAddressService addressService;

    @PostMapping()
    public ResponseEntity<BusinessTripLocationAddressResponse> create(@PathVariable Long locationId, @RequestBody @Valid BusinessTripLocationAddressRequest dto) {
        return new ResponseEntity<>(addressService.toDTO(addressService.create(locationId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BusinessTripLocationAddressResponse>> getAll(@PathVariable Long locationId) {
        return ResponseEntity.ok(addressService.getAllByBusinessTripLocationId(locationId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripLocationAddressResponse> getById(@PathVariable Long locationId, @PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(locationId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripLocationAddressResponse> update(@PathVariable Long locationId, @PathVariable Long id, @RequestBody @Valid BusinessTripLocationAddressRequest dto) {
        return ResponseEntity.ok(addressService.toDTO(addressService.update(locationId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long locationId, @PathVariable Long id) {
        addressService.delete(locationId,id);
        return ResponseEntity.noContent().build();
    }



}
