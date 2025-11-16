package com.fractal.controller.vacation_management;


import com.fractal.domain.vacation_management.request.responsibility.VacationRequestResponsibilityService;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacation-management/request/{vacationRequestId}/responsibility")
@RequiredArgsConstructor
public class VacationRequestResponsibilityController {

    private final VacationRequestResponsibilityService responsibilityService;

    @PostMapping()
    public ResponseEntity<VacationRequestResponsibilityResponse> create(@PathVariable Long vacationRequestId, @RequestBody @Valid VacationRequestResponsibilityRequest dto) {
        return new ResponseEntity<>(responsibilityService.toDTO(responsibilityService.create(vacationRequestId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationRequestResponsibilityResponse>> getAll(@PathVariable Long vacationRequestId) {
        return ResponseEntity.ok(responsibilityService.getAllByVacationRequestId(vacationRequestId).stream().map(responsibilityService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationRequestResponsibilityResponse> getById(@PathVariable Long vacationRequestId, @PathVariable Long id) {
        return ResponseEntity.ok(responsibilityService.toDTO(responsibilityService.getById(vacationRequestId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationRequestResponsibilityResponse> update(@PathVariable Long vacationRequestId, @PathVariable Long id, @RequestBody @Valid VacationRequestResponsibilityRequest dto) {
        return ResponseEntity.ok(responsibilityService.toDTO(responsibilityService.update(vacationRequestId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long vacationRequestId, @PathVariable Long id) {
        responsibilityService.delete(vacationRequestId, id);
        return ResponseEntity.noContent().build();
    }


}
