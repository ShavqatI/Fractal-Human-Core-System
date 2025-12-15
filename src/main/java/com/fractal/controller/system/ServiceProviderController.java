package com.fractal.controller.system;


import com.fractal.domain.system.service_provider.ServiceProviderService;
import com.fractal.domain.system.service_provider.dto.ServiceProviderRequest;
import com.fractal.domain.system.service_provider.dto.ServiceProviderResponse;
import com.fractal.domain.system.service_provider.type.dto.ServiceProviderTypeRequest;
import com.fractal.domain.system.service_provider.type.dto.ServiceProviderTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/system/service-provider")
@RequiredArgsConstructor
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    @PostMapping
    public ResponseEntity<ServiceProviderResponse> create(@RequestBody @Valid ServiceProviderRequest dto) {
        return new ResponseEntity<>(serviceProviderService.toDTO(serviceProviderService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceProviderResponse>> getAll() {
        return ResponseEntity.ok(serviceProviderService.getAll().stream().map(serviceProviderService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceProviderService.toDTO(serviceProviderService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ServiceProviderResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(serviceProviderService.toDTO(serviceProviderService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProviderResponse> update(@PathVariable Long id, @RequestBody @Valid ServiceProviderRequest dto) {
        return ResponseEntity.ok(serviceProviderService.toDTO(serviceProviderService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceProviderService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
