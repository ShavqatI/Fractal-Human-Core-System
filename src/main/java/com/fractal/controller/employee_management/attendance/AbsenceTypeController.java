package com.fractal.controller.employee_management.attendance;


import com.fractal.domain.employee_management.attendance.absence.type.AbsenceTypeService;
import com.fractal.domain.employee_management.attendance.absence.type.dto.AbsenceTypeRequest;
import com.fractal.domain.employee_management.attendance.absence.type.dto.AbsenceTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/attendance/absence/type")
@RequiredArgsConstructor
public class AbsenceTypeController {

    private final AbsenceTypeService absenceTypeService;
    @PostMapping
    public ResponseEntity<AbsenceTypeResponse> create(@RequestBody @Valid AbsenceTypeRequest dto) {
        return new ResponseEntity<>(absenceTypeService.toDTO(absenceTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AbsenceTypeResponse>> getAll() {
        return ResponseEntity.ok(absenceTypeService.getAll().stream().map(absenceTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AbsenceTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(absenceTypeService.toDTO(absenceTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<AbsenceTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(absenceTypeService.toDTO(absenceTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AbsenceTypeResponse> update(@PathVariable Long id, @RequestBody @Valid AbsenceTypeRequest dto) {
      return  ResponseEntity.ok(absenceTypeService.toDTO(absenceTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        absenceTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
