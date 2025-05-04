package com.fractal.controller.location;

import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.country.dto.CountryRequest;
import com.fractal.domain.location.country.dto.CountryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/location/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryResponse> create(@RequestBody @Valid CountryRequest dto) {
        return new ResponseEntity<>(countryService.toDTO(countryService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getAll() {
        return ResponseEntity.ok(countryService.getAll().stream().map(countryService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.toDTO(countryService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CountryResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(countryService.toDTO(countryService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> update(@PathVariable Long id, @RequestBody @Valid CountryRequest dto) {
        return ResponseEntity.ok(countryService.toDTO(countryService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        countryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
