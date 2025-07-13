package com.fractal.controller.employee_management.vacation;


import com.fractal.domain.employee_management.vacation.type.VacationTypeService;
import com.fractal.domain.employee_management.vacation.type.dto.VacationTypeRequest;
import com.fractal.domain.employee_management.vacation.type.dto.VacationTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/vacation/type")
@RequiredArgsConstructor
public class VacationTypeController {

    private final VacationTypeService vacationTypeService;
    @PostMapping
    public ResponseEntity<VacationTypeResponse> create(@RequestBody @Valid VacationTypeRequest dto) {
        return new ResponseEntity<>(vacationTypeService.toDTO(vacationTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<VacationTypeResponse>> getAll() {
        return ResponseEntity.ok(vacationTypeService.getAll().stream().map(vacationTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VacationTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vacationTypeService.toDTO(vacationTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<VacationTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(vacationTypeService.toDTO(vacationTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<VacationTypeResponse> update(@PathVariable Long id, @RequestBody @Valid VacationTypeRequest dto) {
      return  ResponseEntity.ok(vacationTypeService.toDTO(vacationTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
