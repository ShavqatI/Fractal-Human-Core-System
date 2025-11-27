package com.fractal.controller.vacation_management.accrual;


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
@RequestMapping("/api/v1/vacation-management/accrual")
@RequiredArgsConstructor
public class VacationAccrualController {

    private final VacationAccrualService vacationAccrualService;
    private final VacationAccrualUseCaseService accrualUseCaseService;

    @PostMapping
    public ResponseEntity<VacationAccrualResponse> create(@RequestBody @Valid VacationAccrualRequest dto) {
        return new ResponseEntity<>(vacationAccrualService.toDTO(vacationAccrualService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationAccrualResponse>> getAll() {
        return ResponseEntity.ok(vacationAccrualService.getAll().stream().map(vacationAccrualService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("employee/{employeeId}")
    public ResponseEntity<List<VacationAccrualResponse>> getAllByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(vacationAccrualService.getAllByEmployeeId(employeeId).stream().map(vacationAccrualService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationAccrualResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vacationAccrualService.toDTO(vacationAccrualService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationAccrualResponse> update(@PathVariable Long id, @RequestBody @Valid VacationAccrualRequest dto) {
        return ResponseEntity.ok(vacationAccrualService.toDTO(vacationAccrualService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacationAccrualService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/accrual")
    public ResponseEntity<Void> accrual() {
         vacationAccrualService.accrual();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("all-remaining-days/{employeeId}")
    public ResponseEntity<Integer> getEmployeeAllRemainingDays(@PathVariable Long employeeId,@RequestBody @Valid PeriodRequest dto) {
        return new ResponseEntity<>(accrualUseCaseService.getEmployeeAllRemainingDays(employeeId,dto),HttpStatus.OK);
    }


}
