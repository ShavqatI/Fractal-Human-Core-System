package com.fractal.controller.location;

import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.city.dto.CityRequest;
import com.fractal.domain.location.city.dto.CityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/location/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponse> create(@RequestBody @Valid CityRequest dto) {
        return new ResponseEntity<>(cityService.toDTO(cityService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAll() {
        return ResponseEntity.ok(cityService.getAll().stream().map(cityService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.toDTO(cityService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CityResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(cityService.toDTO(cityService.getByCode(code)));
    }
    @GetMapping("/county/{id}")
    public ResponseEntity<List<CityResponse>>  getByRegion(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getByRegionId(id).stream().map(cityService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponse> update(@PathVariable Long id, @RequestBody @Valid CityRequest dto) {
        return ResponseEntity.ok(cityService.toDTO(cityService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
