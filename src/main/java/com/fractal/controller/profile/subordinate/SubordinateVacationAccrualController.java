package com.fractal.controller.profile.subordinate;


import com.fractal.domain.profile.subordinate.vacation.accrual.SubordinateVacationAccrualService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
