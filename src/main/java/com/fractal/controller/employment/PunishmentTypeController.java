package com.fractal.controller.employment;


import com.fractal.domain.employment.punishment.type.PunishmentTypeService;
import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeRequest;
import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employment/punishment-type")
@RequiredArgsConstructor
public class PunishmentTypeController {

    private final PunishmentTypeService punishmentTypeService;

    @PostMapping
    public ResponseEntity<PunishmentTypeResponse> create(@RequestBody @Valid PunishmentTypeRequest dto) {
        return new ResponseEntity<>(punishmentTypeService.toDTO(punishmentTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PunishmentTypeResponse>> getAll() {
        return ResponseEntity.ok(punishmentTypeService.getAll().stream().map(punishmentTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PunishmentTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(punishmentTypeService.toDTO(punishmentTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<PunishmentTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(punishmentTypeService.toDTO(punishmentTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PunishmentTypeResponse> update(@PathVariable Long id, @RequestBody @Valid PunishmentTypeRequest dto) {
        return ResponseEntity.ok(punishmentTypeService.toDTO(punishmentTypeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        punishmentTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
