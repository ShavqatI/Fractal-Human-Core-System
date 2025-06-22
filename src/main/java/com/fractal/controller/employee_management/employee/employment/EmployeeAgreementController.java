package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employee_management.employment.agreement.AgreementService;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/employment-history/{employmentHistoryId}/agreement")
@RequiredArgsConstructor
public class EmployeeAgreementController {

    private final AgreementService agreementService;

    @PostMapping()
    public ResponseEntity<AgreementResponse> create(@PathVariable Long employmentHistoryId, @RequestBody @Valid AgreementRequest dto) {
        return new ResponseEntity<>(agreementService.toDTO(agreementService.create(employmentHistoryId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AgreementResponse>> getAll(@PathVariable Long employmentHistoryId) {
        return ResponseEntity.ok(agreementService.getAllByEmploymentHistoryId(employmentHistoryId).stream().map(agreementService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AgreementResponse> getById(@PathVariable Long employmentHistoryId,@PathVariable Long id) {
        return ResponseEntity.ok(agreementService.toDTO(agreementService.getById(employmentHistoryId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AgreementResponse> update(@PathVariable Long employmentHistoryId, @PathVariable Long id, @RequestBody @Valid AgreementRequest dto) {
        return ResponseEntity.ok(agreementService.toDTO(agreementService.update(employmentHistoryId,id,dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employmentHistoryId, @PathVariable Long id) {
        agreementService.delete(employmentHistoryId,id);
        return ResponseEntity.noContent().build();
    }



}
