package com.fractal.controller.employee_management.insurance;


import com.fractal.domain.insurance.provider.address.InsuranceProviderAddressService;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressRequest;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/insurance/provider/{providerId}/address")
@RequiredArgsConstructor
public class InsuranceProviderAddressController {

    private final InsuranceProviderAddressService addressService;

    @PostMapping()
    public ResponseEntity<InsuranceProviderAddressResponse> create(@PathVariable Long providerId, @RequestBody @Valid InsuranceProviderAddressRequest dto) {
        return new ResponseEntity<>(addressService.toDTO(addressService.create(providerId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InsuranceProviderAddressResponse>> getAll(@PathVariable Long providerId) {
        return ResponseEntity.ok(addressService.getAllByInsuranceProviderId(providerId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceProviderAddressResponse> getById(@PathVariable Long providerId, @PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(providerId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceProviderAddressResponse> update(@PathVariable Long providerId, @PathVariable Long id, @RequestBody @Valid InsuranceProviderAddressRequest dto) {
        return ResponseEntity.ok(addressService.toDTO(addressService.update(providerId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long providerId, @PathVariable Long id) {
        addressService.delete(providerId, id);
        return ResponseEntity.noContent().build();
    }

}
