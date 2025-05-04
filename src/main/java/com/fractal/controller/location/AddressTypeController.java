package com.fractal.controller.location;


import com.fractal.domain.location.address.type.dto.AddressTypeCreate;
import com.fractal.domain.location.address.type.dto.AddressTypeResponse;
import com.fractal.domain.location.address.type.AddressTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/location/address-type")
@RequiredArgsConstructor
public class AddressTypeController {

    private final AddressTypeService addressTypeService;
    @PostMapping
    public ResponseEntity<AddressTypeResponse> create(@RequestBody @Valid AddressTypeCreate dto) {
        return new ResponseEntity<>(addressTypeService.toDTO(addressTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AddressTypeResponse>> getAll() {
        return ResponseEntity.ok(addressTypeService.getAll().stream().map(addressTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(addressTypeService.toDTO(addressTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<AddressTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(addressTypeService.toDTO(addressTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressTypeResponse> update(@PathVariable Long id, @RequestBody @Valid AddressTypeCreate dto) {
      return  ResponseEntity.ok(addressTypeService.toDTO(addressTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
