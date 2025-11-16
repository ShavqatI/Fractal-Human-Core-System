package com.fractal.controller.vacation_management.accrual;


import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecordService;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacation-management/accrual/period/{periodId}/record")
@RequiredArgsConstructor
public class VacationAccrualPeriodRecordController {

    private final VacationAccrualPeriodRecordService periodService;

    @PostMapping()
    public ResponseEntity<VacationAccrualPeriodRecordResponse> create(@PathVariable Long periodId, @RequestBody @Valid VacationAccrualPeriodRecordRequest dto) {
        return new ResponseEntity<>(periodService.toDTO(periodService.create(periodId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationAccrualPeriodRecordResponse>> getAll(@PathVariable Long periodId) {
        return ResponseEntity.ok(periodService.getAllByVacationAccrualPeriodId(periodId).stream().map(periodService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationAccrualPeriodRecordResponse> getById(@PathVariable Long periodId, @PathVariable Long id) {
        return ResponseEntity.ok(periodService.toDTO(periodService.getById(periodId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationAccrualPeriodRecordResponse> update(@PathVariable Long periodId, @PathVariable Long id, @RequestBody @Valid VacationAccrualPeriodRecordRequest dto) {
        return ResponseEntity.ok(periodService.toDTO(periodService.update(periodId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long periodId, @PathVariable Long id) {
        periodService.delete(periodId, id);
        return ResponseEntity.noContent().build();
    }


}
