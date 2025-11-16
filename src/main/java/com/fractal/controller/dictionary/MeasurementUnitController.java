package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.measurement_unit.MeasurementUnitService;
import com.fractal.domain.dictionary.measurement_unit.dto.MeasurementUnitRequest;
import com.fractal.domain.dictionary.measurement_unit.dto.MeasurementUnitResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/measurement-unit")
@RequiredArgsConstructor
public class MeasurementUnitController {

    private final MeasurementUnitService measurementUnitService;

    @PostMapping
    public ResponseEntity<MeasurementUnitResponse> create(@RequestBody @Valid MeasurementUnitRequest dto) {
        return new ResponseEntity<>(measurementUnitService.toDTO(measurementUnitService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MeasurementUnitResponse>> getAll() {
        return ResponseEntity.ok(measurementUnitService.getAll().stream().map(measurementUnitService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementUnitResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(measurementUnitService.toDTO(measurementUnitService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<MeasurementUnitResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(measurementUnitService.toDTO(measurementUnitService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasurementUnitResponse> update(@PathVariable Long id, @RequestBody @Valid MeasurementUnitRequest dto) {
        return ResponseEntity.ok(measurementUnitService.toDTO(measurementUnitService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        measurementUnitService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
