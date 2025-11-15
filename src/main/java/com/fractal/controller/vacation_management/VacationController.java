package com.fractal.controller.vacation_management;


import com.fractal.domain.vacation_management.VacationService;
import com.fractal.domain.vacation_management.dto.VacationRequest;
import com.fractal.domain.vacation_management.dto.VacationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/vacation")
@RequiredArgsConstructor
public class VacationController {

    private final VacationService vacationService;
    @PostMapping
    public ResponseEntity<VacationResponse> create(@RequestBody @Valid VacationRequest dto) {
        return new ResponseEntity<>(vacationService.toDTO(vacationService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<VacationResponse>> getAll() {
        return ResponseEntity.ok(vacationService.getAll().stream().map(vacationService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VacationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vacationService.toDTO(vacationService.getById(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<VacationResponse> update(@PathVariable Long id, @RequestBody @Valid VacationRequest dto) {
      return  ResponseEntity.ok(vacationService.toDTO(vacationService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
