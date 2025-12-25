package com.fractal.controller.profile.candidate;


import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.profile.address.ProfileAddressService;
import com.fractal.domain.profile.candidate.address.CandidateProfileAddressService;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/candidate/address")
@RequiredArgsConstructor
public class CandidateProfileAddressController {

    private final CandidateProfileAddressService addressService;
    @PostMapping()
    public ResponseEntity<CandidateAddressResponse> create(@RequestBody @Valid CandidateAddressRequest dto) {
        return new ResponseEntity<>(addressService.toDTO(addressService.create( dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CandidateAddressResponse>> getAll() {
        return ResponseEntity.ok(addressService.getAll().stream().map(addressService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateAddressResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateAddressResponse> update(@PathVariable Long id, @RequestBody @Valid CandidateAddressRequest dto) {
        return ResponseEntity.ok(addressService.toDTO(addressService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
