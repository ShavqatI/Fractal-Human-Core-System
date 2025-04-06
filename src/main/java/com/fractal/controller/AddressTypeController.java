package com.fractal.controller;

import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.address.type.dto.AddressTypeDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address_type")
@RequiredArgsConstructor
public class AddressTypeController {

    private final AddressTypeService addressTypeService;
    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid AddressTypeDTO addressTypeDTO) {
        addressTypeService.create(addressTypeDTO);
        return ResponseEntity.ok("Hello");
    }
}
