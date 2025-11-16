package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.address.EmployeeAddressService;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/address")
@RequiredArgsConstructor
public class EmployeeAddressController {

    private final EmployeeAddressService addressService;

    @PostMapping()
    public ResponseEntity<EmployeeAddressResponse> create(@PathVariable Long employeeId, @RequestBody @Valid EmployeeAddressRequest dto) {
        return new ResponseEntity<>(addressService.toDTO(addressService.create(employeeId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeAddressResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(addressService.getAllByEmployeeId(employeeId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeAddressResponse> getById(@PathVariable Long employeeId, @PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(employeeId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeAddressResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EmployeeAddressRequest dto) {
        return ResponseEntity.ok(addressService.toDTO(addressService.update(employeeId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        addressService.delete(employeeId, id);
        return ResponseEntity.noContent().build();
    }

}
