package com.fractal.controller.employee_management.attendance;


import com.fractal.domain.employee_management.attendance.AttendanceService;
import com.fractal.domain.employee_management.attendance.dto.AttendanceBatchRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceCancelRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripCancelRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.resource.FileService;
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
    @PutMapping("cancel/{id}")
    public ResponseEntity<AttendanceResponse> cancel(@PathVariable Long id, @RequestBody String reason) {
        return ResponseEntity.ok(attendanceService.toDTO(attendanceService.cancel(new AttendanceCancelRequest(id,reason))));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<AttendanceResponse>> create(@RequestBody @Valid List<AttendanceBatchRequest> dto) {
        return ResponseEntity.ok(attendanceService.create(dto).stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }
    @PutMapping("batch/review")
    public ResponseEntity<List<AttendanceResponse>> review(@RequestBody List<Long> list) {
        return ResponseEntity.ok(attendanceService.review(list).stream().map(attendanceService::toDTO).collect(Collectors.toList()));

    }
    @PutMapping("batch/approve")
    public ResponseEntity<List<AttendanceResponse>> approve(@RequestBody List<Long> list) {
        return ResponseEntity.ok(attendanceService.approve(list).stream().map(attendanceService::toDTO).collect(Collectors.toList()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        attendanceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

   /* @PostMapping("period-report")
    @CrossOrigin(value = "*")
    public ResponseEntity<Resource> periodReport(@RequestBody @Valid AttendancePeriodReportRequest dto) {
        Path path = attendanceService.periodReport(dto);
        return fileService.download(path);
    }*/
}
