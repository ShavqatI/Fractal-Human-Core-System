package com.fractal.controller.profile.employee;


import com.fractal.domain.profile.vacation.accrual.ProfileVacationAccrualService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/vacation/accrual")
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

    @GetMapping("/all-remaining-days")
    public ResponseEntity<Integer> getAllRemainingDays() {
        return new ResponseEntity<>(vacationAccrualService.getAllRemainingDays(),HttpStatus.OK);
    }
    @GetMapping("/payable-remaining-days")
    public ResponseEntity<Integer> getAllRemainingPayableDays() {
        return new ResponseEntity<>(vacationAccrualService.getAllRemainingPayableDays(),HttpStatus.OK);
    }
    @GetMapping("/unpayable-remaining-days")
    public ResponseEntity<Integer> getAllRemainingUnPayableDays() {
        return new ResponseEntity<>(vacationAccrualService.getAllRemainingUnPayableDays(),HttpStatus.OK);
    }
    @GetMapping("/casual-remaining-days")
    public ResponseEntity<Integer> getCasualRemainingDays() {
        return new ResponseEntity<>(vacationAccrualService.getCasualRemainingDays(),HttpStatus.OK);
    }
}
