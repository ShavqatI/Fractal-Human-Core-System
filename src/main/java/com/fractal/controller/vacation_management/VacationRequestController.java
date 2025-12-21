package com.fractal.controller.vacation_management;


import com.fractal.domain.employee_management.attendance.dto.AttendanceCancelRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.request.dto.VacationRequestCancelRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacation-management/request")
@RequiredArgsConstructor
public class VacationRequestController {

    private final VacationRequestService vacationRequestService;

    @PostMapping
    public ResponseEntity<VacationRequestResponse> create(@RequestBody @Valid VacationRequestRequest dto) {
        return new ResponseEntity<>(vacationRequestService.toDTO(vacationRequestService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationRequestResponse>> getAll() {
        return ResponseEntity.ok(vacationRequestService.getAll().stream().map(vacationRequestService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationRequestResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationRequestResponse> update(@PathVariable Long id, @RequestBody @Valid VacationRequestRequest dto) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.update(id, dto)));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<VacationRequestResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.review(id)));
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<VacationRequestResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.approve(id)));
    }

    @PutMapping("cancel/{id}")
    public ResponseEntity<VacationRequestResponse> cancel(@PathVariable Long id, @RequestBody String reason) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.cancel(new VacationRequestCancelRequest(id,reason))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationRequestService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
