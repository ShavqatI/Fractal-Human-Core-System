package com.fractal.controller.location;

import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.district.dto.DistrictCompactResponse;
import com.fractal.domain.location.district.dto.DistrictRequest;
import com.fractal.domain.location.district.dto.DistrictResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/location/district")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;

    @PostMapping
    public ResponseEntity<com.fractal.domain.location.district.dto.DistrictResponse> create(@RequestBody @Valid DistrictRequest dto) {
        return new ResponseEntity<>(districtService.toDTO(districtService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DistrictResponse>> getAll() {
        return ResponseEntity.ok(districtService.getAll().stream().map(districtService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(districtService.toDTO(districtService.getById(id)));
    }

    @GetMapping("compact")
    public ResponseEntity<List<DistrictCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(districtService.getAll().stream().map(districtService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("compact/{id}")
    public ResponseEntity<DistrictCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(districtService.toCompactDTO(districtService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<DistrictResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(districtService.toDTO(districtService.getByCode(code)));
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<List<DistrictResponse>> getByRegion(@PathVariable Long id) {
        return ResponseEntity.ok(districtService.getByRegionId(id).stream().map(districtService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<List<DistrictResponse>> getByCity(@PathVariable Long id) {
        return ResponseEntity.ok(districtService.getByCityId(id).stream().map(districtService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistrictResponse> update(@PathVariable Long id, @RequestBody @Valid DistrictRequest dto) {
        return ResponseEntity.ok(districtService.toDTO(districtService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        districtService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
