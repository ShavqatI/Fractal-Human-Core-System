package com.fractal.controller.profile.employee;


import com.fractal.domain.profile.vacation.request.ProfileVacationRequestRequest;
import com.fractal.domain.profile.vacation.request.ProfileVacationRequestService;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/vacation/request")
@RequiredArgsConstructor
public class ProfileVacationRequestController {

    private final ProfileVacationRequestService vacationRequestService;

    @PostMapping
    public ResponseEntity<VacationRequestResponse> create(@RequestBody @Valid ProfileVacationRequestRequest dto) {
        return new ResponseEntity<>(vacationRequestService.toDTO(vacationRequestService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationRequestResponse>> getAll() {
        return ResponseEntity.ok(vacationRequestService.getAll().stream().map(vacationRequestService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationRequestResponse> update(@PathVariable Long id, @RequestBody @Valid ProfileVacationRequestRequest dto) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.update(id, dto)));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<VacationRequestResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.review(id)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationRequestService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
