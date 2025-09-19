package com.fractal.controller.employee_management.attendance;


import com.fractal.domain.employee_management.attendance.AttendanceService;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;
    @PostMapping
    public ResponseEntity<AttendanceResponse> create(@RequestBody @Valid AttendanceRequest dto) {
        return new ResponseEntity<>(attendanceService.toDTO(attendanceService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AttendanceResponse>> getAll() {
        return ResponseEntity.ok(attendanceService.getAll().stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AttendanceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.toDTO(attendanceService.getById(id)));
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<List<AttendanceResponse>>  getByEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.getAllByEmployeeId(id).stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AttendanceResponse> update(@PathVariable Long id, @RequestBody @Valid AttendanceRequest dto) {
      return  ResponseEntity.ok(attendanceService.toDTO(attendanceService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        attendanceService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
