package com.fractal.controller.profile.employee;


import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.profile.employee.attendance.ProfileAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/attendance")
@RequiredArgsConstructor
public class ProfileAttendanceController {

    private final ProfileAttendanceService attendanceService;
    @GetMapping
    public ResponseEntity<List<AttendanceResponse>> getAll() {
        return ResponseEntity.ok(attendanceService.getAll().stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.toDTO(attendanceService.getById(id)));
    }


}
