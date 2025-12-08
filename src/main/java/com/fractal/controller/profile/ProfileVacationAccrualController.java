package com.fractal.controller.profile;


import com.fractal.domain.profile.vacation.accrual.ProfileVacationAccrualService;
import com.fractal.domain.profile.vacation.request.ProfileVacationRequestRequest;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/vacation/accrual")
@RequiredArgsConstructor
public class ProfileVacationAccrualController {

    private final ProfileVacationAccrualService vacationAccrualService;

    @GetMapping
    public ResponseEntity<List<VacationAccrualResponse>> getAll() {
        return ResponseEntity.ok(vacationAccrualService.getAll().stream().map(vacationAccrualService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/active")
    public ResponseEntity<List<VacationAccrualResponse>> getActive() {
        return ResponseEntity.ok(vacationAccrualService.getActive().stream().map(vacationAccrualService::toDTO).collect(Collectors.toList()));
    }
}
