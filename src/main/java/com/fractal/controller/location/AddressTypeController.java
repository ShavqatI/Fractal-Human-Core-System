package com.fractal.controller.location;

import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.address.type.dto.AddressTypeDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location/address_type")
@RequiredArgsConstructor
public class AddressTypeController {

    private final AddressTypeService addressTypeService;
    @PostMapping
    public ResponseEntity<AddressTypeDTO> create(@RequestBody @Valid AddressTypeDTO addressTypeDTO) {
        return new ResponseEntity<>(addressTypeService.create(addressTypeDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AddressTypeDTO>> getAll() {
        return ResponseEntity.ok(addressTypeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressTypeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(addressTypeService.getById(id));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<AddressTypeDTO> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(addressTypeService.getByCode(code));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressTypeDTO> update(@PathVariable Long id,@RequestBody @Valid AddressTypeDTO addressTypeDTO) {
      return  ResponseEntity.ok(addressTypeService.update(id,addressTypeDTO));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
