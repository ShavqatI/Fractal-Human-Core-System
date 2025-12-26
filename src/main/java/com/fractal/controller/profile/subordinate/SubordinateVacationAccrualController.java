package com.fractal.controller.profile.subordinate;


import com.fractal.domain.profile.subordinate.vacation.accrual.SubordinateVacationAccrualService;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualRequest;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.accrual.period.dto.PeriodRequest;
import com.fractal.domain.vacation_management.accrual.usecase.VacationAccrualUseCaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/subordinate/accrual")
@RequiredArgsConstructor
public class SubordinateVacationAccrualController {

    private final SubordinateVacationAccrualService vacationAccrualService;
    @GetMapping
    public ResponseEntity<List<VacationAccrualResponse>> getAll() {
        return ResponseEntity.ok(vacationAccrualService.getAll().stream().map(vacationAccrualService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/payable-remaining-days/{employeeId}")
    public ResponseEntity<Integer> getEmployeeAllRemainingPayableDays(@PathVariable Long employeeId) {
        return new ResponseEntity<>(vacationAccrualService.getAllEmployeeRemainingPayableDays(employeeId),HttpStatus.OK);
    }
    @GetMapping("/unpayable-remaining-days/{employeeId}")
    public ResponseEntity<Integer> getEmployeeAllRemainingUnPayableDays(@PathVariable Long employeeId) {
        return new ResponseEntity<>(vacationAccrualService.getAllEmployeeRemainingUnPayableDays(employeeId),HttpStatus.OK);
    }
}
