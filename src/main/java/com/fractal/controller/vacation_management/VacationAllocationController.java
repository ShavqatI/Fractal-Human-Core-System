package com.fractal.controller.vacation_management;


import com.fractal.domain.vacation_management.vacation.allocation.VacationAllocationService;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationRequest;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacation-management/vacation/{vacationId}/allocation")
@RequiredArgsConstructor
public class VacationAllocationController {

    private final VacationAllocationService allocationService;

    @PostMapping()
    public ResponseEntity<VacationAllocationResponse> create(@PathVariable Long vacationId, @RequestBody @Valid VacationAllocationRequest dto) {
        return new ResponseEntity<>(allocationService.toDTO(allocationService.create(vacationId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationAllocationResponse>> getAll(@PathVariable Long vacationId) {
        return ResponseEntity.ok(allocationService.getAllByVacationRequestId(vacationId).stream().map(allocationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationAllocationResponse> getById(@PathVariable Long vacationId, @PathVariable Long id) {
        return ResponseEntity.ok(allocationService.toDTO(allocationService.getById(vacationId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationAllocationResponse> update(@PathVariable Long vacationId, @PathVariable Long id, @RequestBody @Valid VacationAllocationRequest dto) {
        return ResponseEntity.ok(allocationService.toDTO(allocationService.update(vacationId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long vacationId, @PathVariable Long id) {
        allocationService.delete(vacationId, id);
        return ResponseEntity.noContent().build();
    }


}
