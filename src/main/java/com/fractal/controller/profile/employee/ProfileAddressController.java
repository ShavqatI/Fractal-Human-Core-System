package com.fractal.controller.profile.employee;


import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.profile.address.ProfileAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/address")
@RequiredArgsConstructor
public class ProfileAddressController {

    private final ProfileAddressService addressService;
    @GetMapping
    public ResponseEntity<List<EmployeeAddressResponse>> getAll() {
        return ResponseEntity.ok(addressService.getAll().stream().map(addressService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeAddressResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(id)));
    }


}
