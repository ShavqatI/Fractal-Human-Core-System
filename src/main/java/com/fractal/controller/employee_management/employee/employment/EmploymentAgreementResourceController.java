package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employment.internal.agreement.resource.InternalEmploymentAgreementResourceService;
import com.fractal.domain.resource.dto.ResourceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/employment/agreement/{agreementId}/resource")
@RequiredArgsConstructor
public class EmploymentAgreementResourceController {

    private final InternalEmploymentAgreementResourceService resourceService;

    @PostMapping()
    public ResponseEntity<ResourceResponse> create(@PathVariable Long agreementId, @RequestBody @Valid MultipartFile file) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(agreementId,file)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll(@PathVariable Long agreementId) {
        return ResponseEntity.ok(resourceService.getAllByAgreementId(agreementId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable Long agreementId,@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(agreementId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResourceResponse> update(@PathVariable Long agreementId, @PathVariable Long id, @RequestBody @Valid MultipartFile file) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(agreementId,id, file)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long agreementId, @PathVariable Long id) {
        resourceService.delete(agreementId,id);
        return ResponseEntity.noContent().build();
    }



}
