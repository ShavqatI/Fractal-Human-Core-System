package com.fractal.controller.profile.subordinate;


import com.fractal.domain.profile.subordinate.vacation.request.SubordinateVacationRequestRequest;
import com.fractal.domain.profile.subordinate.vacation.request.SubordinateVacationRequestService;
import com.fractal.domain.profile.vacation.request.ProfileVacationRequestRequest;
import com.fractal.domain.profile.vacation.request.ProfileVacationRequestService;
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
@RequestMapping("/api/v1/profile-management/subordinate/vacation/request")
@RequiredArgsConstructor
public class SubordinateVacationRequestController {

    private final SubordinateVacationRequestService vacationRequestService;

    @PostMapping
    public ResponseEntity<VacationRequestResponse> create(@RequestBody @Valid SubordinateVacationRequestRequest dto) {
        return new ResponseEntity<>(vacationRequestService.toDTO(vacationRequestService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationRequestResponse>> getAll() {
        return ResponseEntity.ok(vacationRequestService.getAll().stream().map(vacationRequestService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationRequestResponse> update(@PathVariable Long id, @RequestBody @Valid SubordinateVacationRequestRequest dto) {
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

    @GetMapping("close/{id}")
    public ResponseEntity<Void> close(@PathVariable Long id) {
        vacationRequestService.close(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationRequestService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
