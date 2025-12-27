package com.fractal.controller.profile.employee;


import com.fractal.domain.profile.employee.vacation.schedule.ProfileVacationScheduleRequest;
import com.fractal.domain.profile.employee.vacation.schedule.ProfileVacationScheduleService;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/vacation/schedule")
@RequiredArgsConstructor
public class ProfileVacationScheduleController {

    private final ProfileVacationScheduleService vacationScheduleService;

    @PostMapping
    public ResponseEntity<VacationScheduleResponse> create(@RequestBody @Valid ProfileVacationScheduleRequest dto) {
        return new ResponseEntity<>(vacationScheduleService.toDTO(vacationScheduleService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationScheduleResponse>> getAll() {
        return ResponseEntity.ok(vacationScheduleService.getAll().stream().map(vacationScheduleService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationScheduleResponse> update(@PathVariable Long id, @RequestBody @Valid ProfileVacationScheduleRequest dto) {
        return ResponseEntity.ok(vacationScheduleService.toDTO(vacationScheduleService.update(id, dto)));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<VacationScheduleResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(vacationScheduleService.toDTO(vacationScheduleService.review(id)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationScheduleService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
