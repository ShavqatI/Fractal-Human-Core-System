package com.fractal.controller.employee_management.employee.relative;


import com.fractal.domain.employee_management.relative.address.RelativeAddressService;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/relative/{relativeId}/address")
@RequiredArgsConstructor
public class EmployeeRelativeAddressController {

    private final RelativeAddressService addressService;

    @PostMapping()
    public ResponseEntity<RelativeAddressResponse> create(@PathVariable Long relativeId, @RequestBody @Valid RelativeAddressRequest dto) {
        return new ResponseEntity<>(addressService.toDTO(addressService.create(relativeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<RelativeAddressResponse>> getAll(@PathVariable Long relativeId) {
        return ResponseEntity.ok(addressService.getAllByRelativeId(relativeId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RelativeAddressResponse> getById(@PathVariable Long relativeId,@PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(relativeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RelativeAddressResponse> update(@PathVariable Long relativeId, @PathVariable Long id, @RequestBody @Valid RelativeAddressRequest dto) {
        return ResponseEntity.ok(addressService.toDTO(addressService.update(relativeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long relativeId, @PathVariable Long id) {
        addressService.delete(relativeId,id);
        return ResponseEntity.noContent().build();
    }



}
