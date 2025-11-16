package com.fractal.controller.vacation_management.accrual;


import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriodService;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodRequest;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacation-management/accrual/{accrualId}/period")
@RequiredArgsConstructor
public class VacationAccrualPeriodController {

    private final VacationAccrualPeriodService periodService;

    @PostMapping()
    public ResponseEntity<VacationAccrualPeriodResponse> create(@PathVariable Long accrualId, @RequestBody @Valid VacationAccrualPeriodRequest dto) {
        return new ResponseEntity<>(periodService.toDTO(periodService.create(accrualId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<VacationAccrualPeriodResponse>> getAll(@PathVariable Long accrualId) {
        return ResponseEntity.ok(periodService.getAllByVacationAccrualId(accrualId).stream().map(periodService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VacationAccrualPeriodResponse> getById(@PathVariable Long accrualId, @PathVariable Long id) {
        return ResponseEntity.ok(periodService.toDTO(periodService.getById(accrualId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<VacationAccrualPeriodResponse> update(@PathVariable Long accrualId, @PathVariable Long id, @RequestBody @Valid VacationAccrualPeriodRequest dto) {
        return ResponseEntity.ok(periodService.toDTO(periodService.update(accrualId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long accrualId, @PathVariable Long id) {
        periodService.delete(accrualId,id);
        return ResponseEntity.noContent().build();
    }



}
