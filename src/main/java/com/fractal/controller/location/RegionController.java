package com.fractal.controller.location;

import com.fractal.domain.location.region.RegionService;
import com.fractal.domain.location.region.dto.RegionRequest;
import com.fractal.domain.location.region.dto.RegionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/location/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @PostMapping
    public ResponseEntity<RegionResponse> create(@RequestBody @Valid RegionRequest dto) {
        return new ResponseEntity<>(regionService.toDTO(regionService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RegionResponse>> getAll() {
        return ResponseEntity.ok(regionService.getAll().stream().map(regionService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.toDTO(regionService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<RegionResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(regionService.toDTO(regionService.getByCode(code)));
    }
    @GetMapping("/county/{id}")
    public ResponseEntity<List<RegionResponse>>  getByCountry(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.getByCountryId(id).stream().map(regionService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionResponse> update(@PathVariable Long id, @RequestBody @Valid RegionRequest dto) {
        return ResponseEntity.ok(regionService.toDTO(regionService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        regionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
