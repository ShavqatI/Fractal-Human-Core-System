package com.fractal.controller.integration.mapping;

import com.fractal.domain.integration.mapping.vacation_type.VacationTypeMappingService;
import com.fractal.domain.integration.mapping.vacation_type.dto.VacationTypeMappingRequest;
import com.fractal.domain.integration.mapping.vacation_type.dto.VacationTypeMappingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/integration/mapping/vacation-type")
@RequiredArgsConstructor
public class VacationTypeMappingController {

    private final VacationTypeMappingService vacationTypeMappingService;


    @PostMapping
    public ResponseEntity<VacationTypeMappingResponse> create(@RequestBody @Valid VacationTypeMappingRequest dto) {
        return new ResponseEntity<>(vacationTypeMappingService.toDTO(vacationTypeMappingService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationTypeMappingResponse>> getAll() {
        return ResponseEntity.ok(vacationTypeMappingService.getAll().stream().map(vacationTypeMappingService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationTypeMappingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vacationTypeMappingService.toDTO(vacationTypeMappingService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationTypeMappingResponse> update(@PathVariable Long id, @RequestBody @Valid VacationTypeMappingRequest dto) {
        return ResponseEntity.ok(vacationTypeMappingService.toDTO(vacationTypeMappingService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationTypeMappingService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
