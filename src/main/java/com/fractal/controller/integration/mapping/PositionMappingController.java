package com.fractal.controller.integration.mapping;

import com.fractal.domain.integration.mapping.department.dto.DepartmentMappingRequest;
import com.fractal.domain.integration.mapping.department.dto.DepartmentMappingResponse;
import com.fractal.domain.integration.mapping.position.PositionMappingService;
import com.fractal.domain.integration.mapping.position.dto.PositionMappingRequest;
import com.fractal.domain.integration.mapping.position.dto.PositionMappingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/integration/mapping/position")
@RequiredArgsConstructor
public class PositionMappingController {

    private final PositionMappingService positionMappingService;


    @PostMapping
    public ResponseEntity<PositionMappingResponse> create(@RequestBody @Valid PositionMappingRequest dto) {
        return new ResponseEntity<>(positionMappingService.toDTO(positionMappingService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PositionMappingResponse>> getAll() {
        return ResponseEntity.ok(positionMappingService.getAll().stream().map(positionMappingService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PositionMappingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(positionMappingService.toDTO(positionMappingService.getById(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PositionMappingResponse> update(@PathVariable Long id, @RequestBody @Valid PositionMappingRequest dto) {
      return  ResponseEntity.ok(positionMappingService.toDTO(positionMappingService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        positionMappingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
