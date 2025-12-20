package com.fractal.controller.employee_management.attendance;


import com.fractal.domain.employee_management.attendance.AttendanceService;
import com.fractal.domain.employee_management.attendance.dto.AttendanceBatchRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendancePeriodReportRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.resource.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final FileService fileService;

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
    public ResponseEntity<List<AttendanceResponse>> getByEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.getAllByEmployeeId(id).stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/user/all")
    public ResponseEntity<List<AttendanceResponse>> getAllByUser() {
        return ResponseEntity.ok(attendanceService.getAllByUserId().stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/user/created")
    public ResponseEntity<List<AttendanceResponse>> getAllByUserCreated() {
        return ResponseEntity.ok(attendanceService.getAllByUserIdCreated().stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/user/reviewed")
    public ResponseEntity<List<AttendanceResponse>> getAllByUserReviewed() {
        return ResponseEntity.ok(attendanceService.getAllByUserIdReviewed().stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/user/approved")
    public ResponseEntity<List<AttendanceResponse>> getAllByUserApproved() {
        return ResponseEntity.ok(attendanceService.getAllByUserIdApproved().stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<AttendanceResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.toDTO(attendanceService.review(id)));
    }
    @PutMapping("approve/{id}")
    public ResponseEntity<AttendanceResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.toDTO(attendanceService.approve(id)));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<AttendanceResponse>> create(@RequestBody @Valid List<AttendanceBatchRequest> dto) {
        return ResponseEntity.ok(attendanceService.create(dto).stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }
    @PutMapping("batch/review")
    public ResponseEntity<List<AttendanceResponse>> review(List<Long> list) {
        return ResponseEntity.ok(attendanceService.review(list).stream().map(attendanceService::toDTO).collect(Collectors.toList()));

    }
    @PutMapping("batch/approve")
    public ResponseEntity<List<AttendanceResponse>> approve(List<Long> list) {
        return ResponseEntity.ok(attendanceService.approve(list).stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        attendanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("period-report")
    @CrossOrigin(value = "*")
    public ResponseEntity<Resource> periodReport(@RequestBody @Valid AttendancePeriodReportRequest dto) {
        Path path = attendanceService.periodReport(dto);
        return fileService.download(path);
    }
}
