package com.fractal.controller.vacation_management;


import com.fractal.domain.vacation_management.request.education.VacationRequestEducationService;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationRequest;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacation-management/request/{vacationRequestId}/education")
@RequiredArgsConstructor
public class VacationRequestEducationController {

    private final VacationRequestEducationService educationService;

    @PostMapping()
    public ResponseEntity<VacationRequestEducationResponse> create(@PathVariable Long vacationRequestId, @RequestBody @Valid VacationRequestEducationRequest dto) {
        return new ResponseEntity<>(educationService.toDTO(educationService.create(vacationRequestId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationRequestEducationResponse>> getAll(@PathVariable Long vacationRequestId) {
        return ResponseEntity.ok(educationService.getAllByVacationRequestId(vacationRequestId).stream().map(educationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationRequestEducationResponse> getById(@PathVariable Long vacationRequestId, @PathVariable Long id) {
        return ResponseEntity.ok(educationService.toDTO(educationService.getById(vacationRequestId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationRequestEducationResponse> update(@PathVariable Long vacationRequestId, @PathVariable Long id, @RequestBody @Valid VacationRequestEducationRequest dto) {
        return ResponseEntity.ok(educationService.toDTO(educationService.update(vacationRequestId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long vacationRequestId, @PathVariable Long id) {
        educationService.delete(vacationRequestId, id);
        return ResponseEntity.noContent().build();
    }


}
