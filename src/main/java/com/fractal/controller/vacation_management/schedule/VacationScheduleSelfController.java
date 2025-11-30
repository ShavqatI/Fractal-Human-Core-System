package com.fractal.controller.vacation_management.schedule;


import com.fractal.domain.vacation_management.schedule.VacationScheduleService;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleSelfRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacation-management/schedule/self")
@RequiredArgsConstructor
public class VacationScheduleSelfController {

    private final VacationScheduleService vacationScheduleService;

    @PostMapping
    public ResponseEntity<VacationScheduleResponse> create(@RequestBody @Valid VacationScheduleSelfRequest dto) {
        return new ResponseEntity<>(vacationScheduleService.toDTO(vacationScheduleService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationScheduleResponse>> getAll() {
        return ResponseEntity.ok(vacationScheduleService.getAllByEmployeeId().stream().map(vacationScheduleService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationScheduleResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vacationScheduleService.toDTO(vacationScheduleService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationScheduleResponse> update(@PathVariable Long id, @RequestBody @Valid VacationScheduleSelfRequest dto) {
        return ResponseEntity.ok(vacationScheduleService.toDTO(vacationScheduleService.update(id, dto)));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<VacationScheduleResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(vacationScheduleService.toDTO(vacationScheduleService.review(id)));
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<VacationScheduleResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(vacationScheduleService.toDTO(vacationScheduleService.approve(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationScheduleService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
