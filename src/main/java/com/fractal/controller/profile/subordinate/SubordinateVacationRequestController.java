package com.fractal.controller.profile.subordinate;


import com.fractal.domain.profile.subordinate.vacation.request.SubordinateVacationRequestRequest;
import com.fractal.domain.profile.subordinate.vacation.request.SubordinateVacationRequestService;
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
@RequestMapping("/api/v1/profile-management/subordinate/vacation/request")
@RequiredArgsConstructor
public class SubordinateVacationRequestController {

    private final SubordinateVacationRequestService vacationRequestService;

    @GetMapping
    public ResponseEntity<List<VacationRequestResponse>> getAll() {
        return ResponseEntity.ok(vacationRequestService.getAll().stream().map(vacationRequestService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationRequestResponse> update(@PathVariable Long id, @RequestBody @Valid SubordinateVacationRequestRequest dto) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.update(id, dto)));
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<VacationRequestResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(vacationRequestService.toDTO(vacationRequestService.approve(id)));
    }

}
