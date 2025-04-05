package com.fractal.controller;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.location.address.type.AddressType;
import com.fractal.domain.location.address.type.AddressTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address_type")
@RequiredArgsConstructor
public class AddressTypeController {

    private final AddressTypeService addressTypeService;
    @GetMapping
    public ResponseEntity<String> test() {
        AddressType addressType = AddressType.builder().code("hello").name("blllla").build();
        addressTypeService.update(1L,addressType);
        return ResponseEntity.ok("Hello");
    }
}
