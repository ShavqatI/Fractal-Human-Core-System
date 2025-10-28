package com.fractal.controller.employee_management.attendance;


import com.fractal.domain.employee_management.attendance.absence.AbsenceService;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/attendance/absence")
@RequiredArgsConstructor
public class AbsenceController {

    private final AbsenceService absenceService;
    @PostMapping
    public ResponseEntity<AbsenceResponse> create(@RequestBody @Valid AbsenceRequest dto) {
        return new ResponseEntity<>(absenceService.toDTO(absenceService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AbsenceResponse>> getAll() {
        return ResponseEntity.ok(absenceService.getAll().stream().map(absenceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AbsenceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(absenceService.toDTO(absenceService.getById(id)));
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<List<AbsenceResponse>>  getByEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(absenceService.getAllByEmployeeId(id).stream().map(absenceService::toDTO).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AbsenceResponse> update(@PathVariable Long id, @RequestBody @Valid AbsenceRequest dto) {
      return  ResponseEntity.ok(absenceService.toDTO(absenceService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        absenceService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
