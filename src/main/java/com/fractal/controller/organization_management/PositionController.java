package com.fractal.controller.organization_management;

import com.fractal.domain.order.employment.dto.EmploymentOrderResponse;
import com.fractal.domain.organization_management.position.PositionService;
import com.fractal.domain.organization_management.position.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/position")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    public ResponseEntity<PositionResponse> create(@RequestBody @Valid PositionRequest dto) {
        return new ResponseEntity<>(positionService.toDTO(positionService.create(dto)), HttpStatus.CREATED);
    }
    @PostMapping("bulck")
    public ResponseEntity<Void> create(@RequestBody @Valid List<PositionRequest> dto) {
         positionService.create(dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PositionResponse>> getAll() {
        return ResponseEntity.ok(positionService.getAll().stream().map(positionService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.toDTO(positionService.getById(id)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<PositionCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(positionService.getAll().stream().map(positionService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<PositionCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.toCompactDTO(positionService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<PositionResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(positionService.toDTO(positionService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionResponse> update(@PathVariable Long id, @RequestBody @Valid PositionRequest dto) {
        return ResponseEntity.ok(positionService.toDTO(positionService.update(id, dto)));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<PositionResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.toDTO(positionService.review(id)));
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<PositionResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.toDTO(positionService.approve(id)));
    }
    @PutMapping("cancel/{id}")
    public ResponseEntity<PositionResponse> cancel(@PathVariable Long id,@RequestBody @Valid PositionCancelRequest dto) {
        return ResponseEntity.ok(positionService.toDTO(positionService.cancel(id,dto)));
    }
    @PutMapping("close/{id}")
    public ResponseEntity<PositionResponse> close(@PathVariable Long id,@RequestBody @Valid PositionCloseRequest dto) {
        return ResponseEntity.ok(positionService.toDTO(positionService.close(id,dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        positionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
