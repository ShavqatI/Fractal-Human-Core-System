package com.fractal.controller.location;


import com.fractal.domain.location.address.type.AddressTypeDto;
import com.fractal.domain.location.address.type.AddressTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location/address-type")
@RequiredArgsConstructor
public class AddressTypeController {

    private final AddressTypeService addressTypeService;
    @PostMapping
    public ResponseEntity<AddressTypeDto> create(@RequestBody @Valid AddressTypeDto addressTypeDTO) {
        return new ResponseEntity<>(addressTypeService.create(addressTypeDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AddressTypeDto>> getAll() {
        return ResponseEntity.ok(addressTypeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressTypeDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(addressTypeService.getById(id));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<AddressTypeDto> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(addressTypeService.getByCode(code));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressTypeDto> update(@PathVariable Long id, @RequestBody @Valid AddressTypeDto addressTypeDTO) {
      return  ResponseEntity.ok(addressTypeService.update(id,addressTypeDTO));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
