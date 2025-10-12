package com.fractal.controller.employee_management.employee.employment;

import com.fractal.domain.employment.internal.agreement.InternalEmploymentAgreementService;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementRequest;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/employment/{employmentId}/agreement")
@RequiredArgsConstructor
public class EmploymentAgreementController {

    private final InternalEmploymentAgreementService agreementService;

    @PostMapping()
    public ResponseEntity<InternalEmploymentAgreementResponse> create(@PathVariable Long employmentId, @RequestBody @Valid InternalEmploymentAgreementRequest dto) {
        return new ResponseEntity<>(agreementService.toDTO(agreementService.create(employmentId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InternalEmploymentAgreementResponse>> getAll(@PathVariable Long employmentId) {
        return ResponseEntity.ok(agreementService.getAllByInternalEmploymentId(employmentId).stream().map(agreementService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InternalEmploymentAgreementResponse> getById(@PathVariable Long employmentId, @PathVariable Long id) {
        return ResponseEntity.ok(agreementService.toDTO(agreementService.getById(employmentId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InternalEmploymentAgreementResponse> update(@PathVariable Long employmentId, @PathVariable Long id, @RequestBody @Valid InternalEmploymentAgreementRequest dto) {
        return ResponseEntity.ok(agreementService.toDTO(agreementService.update(employmentId,id,dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employmentId, @PathVariable Long id) {
        agreementService.delete(employmentId,id);
        return ResponseEntity.noContent().build();
    }



}
