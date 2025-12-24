package com.fractal.controller.profile.subordinate;


import com.fractal.domain.profile.subordinate.vacation.schedule.SubordinateVacationScheduleRequest;
import com.fractal.domain.profile.subordinate.vacation.schedule.SubordinateVacationScheduleService;
import com.fractal.domain.profile.vacation.schedule.ProfileVacationScheduleRequest;
import com.fractal.domain.profile.vacation.schedule.ProfileVacationScheduleService;
import com.fractal.domain.vacation_management.request.dto.VacationRequestCancelRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleCancelRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/subordinate/vacation/schedule")
@RequiredArgsConstructor
public class SubordinateVacationScheduleController {

    private final SubordinateVacationScheduleService vacationScheduleService;

    @PostMapping
    public ResponseEntity<VacationScheduleResponse> create(@RequestBody @Valid SubordinateVacationScheduleRequest dto) {
        return new ResponseEntity<>(vacationScheduleService.toDTO(vacationScheduleService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationScheduleResponse>> getAll() {
        return ResponseEntity.ok(vacationScheduleService.getAll().stream().map(vacationScheduleService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationScheduleResponse> update(@PathVariable Long id, @RequestBody @Valid SubordinateVacationScheduleRequest dto) {
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

    @PutMapping("cancel/{id}")
    public ResponseEntity<VacationScheduleResponse> cancel(@PathVariable Long id, @RequestBody String reason) {
        return ResponseEntity.ok(vacationScheduleService.toDTO(vacationScheduleService.cancel(new VacationScheduleCancelRequest(id,reason))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationScheduleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
