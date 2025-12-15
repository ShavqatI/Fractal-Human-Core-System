package com.fractal.controller.system;


import com.fractal.domain.system.message.type.dto.MessageTypeRequest;
import com.fractal.domain.system.service_provider.type.ServiceProviderTypeService;
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
@RequestMapping("/api/v1/system/service-provider/type")
@RequiredArgsConstructor
public class ServiceProviderTypeController {

    private final ServiceProviderTypeService serviceProviderTypeService;

    @PostMapping
    public ResponseEntity<ServiceProviderTypeResponse> create(@RequestBody @Valid ServiceProviderTypeRequest dto) {
        return new ResponseEntity<>(serviceProviderTypeService.toDTO(serviceProviderTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceProviderTypeResponse>> getAll() {
        return ResponseEntity.ok(serviceProviderTypeService.getAll().stream().map(serviceProviderTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceProviderTypeService.toDTO(serviceProviderTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ServiceProviderTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(serviceProviderTypeService.toDTO(serviceProviderTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProviderTypeResponse> update(@PathVariable Long id, @RequestBody @Valid ServiceProviderTypeRequest dto) {
        return ResponseEntity.ok(serviceProviderTypeService.toDTO(serviceProviderTypeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceProviderTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
